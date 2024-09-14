package com.bdk.startertest.user.serivce;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bdk.startertest.model.common.dto.ResponseResult;
import com.bdk.startertest.model.user.dto.UserAuthDTO;
import com.bdk.startertest.model.user.entity.User;

public interface UserService extends IService<User> {
    public ResponseResult login(UserAuthDTO dto);
}
