package com.bdk.startertest.user.serivce.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bdk.common.AppJwtUtil;
import com.bdk.common.dto.ResponseResult;
import com.bdk.common.enums.AppHttpCodeEnum;
import com.bdk.startertest.user.serivce.UserService;
import com.bdk.user.dto.UserAuthDTO;
import com.bdk.user.entity.User;
import com.bdk.startertest.user.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    public ResponseResult login(UserAuthDTO dto) {
        if (!StringUtils.isBlank(dto.getUserName())) {

            //query database with username
            User user = lambdaQuery().eq(User::getUserName, dto.getUserName()).one();
            if (user == null) {
                //username doesnot exist
                return ResponseResult.errorResult(AppHttpCodeEnum.AP_USER_DATA_NOT_EXIST);
            }
            // transfer dto password into md5
            String digestAsHex = DigestUtils.md5DigestAsHex(dto.getPassword().getBytes());
            if (!digestAsHex.equals(user.getPassword())) {
                //compare password
                return ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_PASSWORD_ERROR);
            }

            // return  jwt  user
            String token = AppJwtUtil.getToken(user.getId());
            Map<String, Object> map = new HashMap<>();
            map.put("token", token);
            user.setPassword("");
            map.put("user", user);

            return ResponseResult.okResult(map);
        } else {
            //2.log in as guest
            Map<String, Object> map = new HashMap<>();
            map.put("token", AppJwtUtil.getToken(0L));
            return ResponseResult.okResult(map);
        }


    }
}
