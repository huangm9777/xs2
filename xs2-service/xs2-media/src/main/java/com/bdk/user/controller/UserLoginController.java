package com.bdk.user.controller;

import com.bdk.model.common.dto.ResponseResult;
import com.bdk.model.user.dto.LoginDto;

import com.bdk.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@CrossOrigin
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

    /**
     * retrieve user info
     * @return
     */
    @GetMapping("/profile")
    public ResponseResult userProfile(){
        return userService.userProfile();
    }


}
