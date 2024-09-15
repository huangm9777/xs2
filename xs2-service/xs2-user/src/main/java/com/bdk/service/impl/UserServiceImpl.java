package com.bdk.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bdk.mapper.UserMapper;
import com.bdk.model.common.dto.ResponseResult;
import com.bdk.model.common.enums.AppHttpCodeEnum;
import com.bdk.model.user.dto.LoginDto;
import com.bdk.model.user.pojo.ApUser;
import com.bdk.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

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



            return ResponseResult.okResult(dbUser.getId());
        }else {
                //login as guest
                return ResponseResult.okResult(Integer.valueOf(0));
        }
    }
}
