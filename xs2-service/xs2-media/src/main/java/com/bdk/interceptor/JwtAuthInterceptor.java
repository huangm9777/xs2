package com.bdk.interceptor;

import com.bdk.common.utils.AppJwtUtil;
import com.bdk.common.utils.ThreadUtil;
import com.bdk.model.common.enums.JwrClaimsConstant;
import com.bdk.model.user.pojo.ApUser;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtAuthInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断当前拦截到的是Controller的方法还是其他资源
        if (!(handler instanceof HandlerMethod)) {
            //当前拦截到的不是动态方法，直接放行
            return true;
        }
        //2.判断是否是登录
        if (request.getRequestURI().contains("/login")){
            return true;
        }
        // 校验令牌
        try {
            //3.获取token
            String token = request.getHeader("Authorization");
            token = token.substring(token.indexOf(" ")+1);

            Claims claimsBody = AppJwtUtil.getClaimsBody(token);

            Integer userId = (Integer) claimsBody.get("id");

            ThreadUtil.setCurrentId(userId);
//            Claims claims = appJwtUtil.get.parseJWT(jwtProperties.getAdminSecretKey(), token);
//            Long empId = Long.valueOf(claims.get(JwtClaimsConstant.EMP_ID).toString());
//            put login id into thread local
//            BaseContext.setCurrentId(empId);

//            log.info("当前员工id：", userId);
            //3、通过，放行
            return true;
        } catch (Exception ex) {
            //4、不通过，响应401状态码

            response.setStatus(401);
            return false;
        }

    }
}
