package com.bdk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bdk.model.common.dto.ResponseResult;
import com.bdk.model.user.dto.LoginDto;
import com.bdk.model.user.pojo.ApUser;

public interface UserService extends IService<ApUser> {

    /**
     * login validate
     * @param dto
     * @return
     */
    public ResponseResult login(LoginDto dto);
}
