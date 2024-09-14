package com.bdk.startertest.user.controller;

import com.bdk.startertest.model.common.dto.ResponseResult;
import com.bdk.startertest.user.serivce.UserService;
import com.bdk.startertest.model.user.dto.UserAuthDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserAuthController {

    private final UserService userService;
    @PostMapping("/login")
    public ResponseResult login(@RequestBody UserAuthDTO dto){
        return userService.login(dto);

    }

}
