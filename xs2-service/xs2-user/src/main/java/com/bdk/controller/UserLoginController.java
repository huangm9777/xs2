package com.bdk.controller;

import com.bdk.model.common.dto.ResponseResult;
import com.bdk.model.user.dto.LoginDto;
import com.bdk.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserLoginController {

    private final UserService userService;

    /**
     * user login
     * @param dto
     * @return
     */
    @PostMapping("/login")
    public ResponseResult login(@RequestBody LoginDto dto){
        return userService.login(dto);
    }
}
