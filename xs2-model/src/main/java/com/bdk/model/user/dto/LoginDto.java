package com.bdk.model.user.dto;

import lombok.Data;

@Data
public class LoginDto {

    /**
     * username
     */
    private String name;

    /**
     * 密码
     */
    private String password;
}