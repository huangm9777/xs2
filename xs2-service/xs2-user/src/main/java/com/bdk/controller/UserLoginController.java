package com.bdk.controller;

import com.bdk.model.common.dto.ResponseResult;
import com.bdk.model.common.enums.AppHttpCodeEnum;
import com.bdk.model.user.dto.LoginDto;
import com.bdk.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@CrossOrigin
public class UserLoginController {

    private final UserService userService;

    /**
     * test
     * @return
     */
    @CrossOrigin
    @PostMapping("/prof")
    public String test(){
        return "hello";
    }
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
