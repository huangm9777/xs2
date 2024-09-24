package com.bdk.user.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bdk.common.utils.AppJwtUtil;

import com.bdk.common.utils.ThreadUtil;
import com.bdk.model.common.dto.ResponseResult;
import com.bdk.model.common.enums.AppHttpCodeEnum;
import com.bdk.model.user.dto.LoginDto;
import com.bdk.model.user.pojo.ApUser;

import com.bdk.user.mapper.UserMapper;
import com.bdk.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, ApUser> implements UserService {
    /**
     * login validate
     * @param dto
     * @return
     */
    @Override
    public ResponseResult login(LoginDto dto) {

        if(StringUtils.isNotBlank(dto.getName()) || StringUtils.isNotBlank(dto.getPassword())){

//            ApUser one = lambdaQuery().eq(ApUser::getPhone, dto.getPhone()).one();
            ApUser dbUser = getOne(Wrappers.<ApUser>lambdaQuery().eq(ApUser::getName, dto.getName()));
            if(dbUser == null){
                return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST,"用户信息不存在");
            }

            //1.2 比对密码
            String salt = dbUser.getSalt();
            String password = dto.getPassword();
            String pswd = DigestUtils.md5DigestAsHex((password + salt).getBytes());
            if(!pswd.equals(dbUser.getPassword())){
                return ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_PASSWORD_ERROR);
            }
            // generate JWT 


            //1.3 返回数据  jwt  user
            String token = AppJwtUtil.getToken(dbUser.getId());
            Map<String,Object> map = new HashMap<>();
            map.put("token",token);
            dbUser.setSalt("");
            dbUser.setPassword("");
            map.put("user",dbUser);

            return ResponseResult.okResult(map);
        }else {
                Map<String,Object> map = new HashMap<>();
                String token = AppJwtUtil.getToken(0);
                map.put("token",token);
                //login as guest
                return ResponseResult.okResult(map);
        }
    }

    @Override
    public ResponseResult userProfile() {
        Integer userId = ThreadUtil.getCurrentId();
        if (userId == null){
            return ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }
        ApUser apUser = lambdaQuery().eq(ApUser::getId, userId).one();
        apUser.setPassword("***");
        apUser.setSalt("***");

        return ResponseResult.okResult(apUser);
    }


}
