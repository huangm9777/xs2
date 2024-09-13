package com.bdk.startertest.user.serivce;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bdk.common.dto.ResponseResult;
import com.bdk.user.dto.UserAuthDTO;
import com.bdk.user.entity.User;

public interface UserService extends IService<User> {
    public ResponseResult login(UserAuthDTO dto);
}
