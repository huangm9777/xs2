package com.bdk.user.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserAuthDTO implements Serializable {

    private String userName;

    private String password;
}
