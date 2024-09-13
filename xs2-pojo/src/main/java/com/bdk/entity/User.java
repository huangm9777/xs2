package com.bdk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

import java.util.Date;


/**
* 
* @TableName user
*/
@Data
@TableName("user")
public class User implements Serializable {

    /**
    * 
    */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
    * 
    */

    private String userName;
    /**
    * 
    */

    private String name;
    /**
    * 
    */

    private String password;
    /**
    * 
    */

    private String phone;
    /**
    * 
    */

    private String sex;
    /**
    * 
    */

    private String avatar;
    /**
    * 
    */

    private Date createTime;
    /**
    * 
    */

    private Integer status;

}
