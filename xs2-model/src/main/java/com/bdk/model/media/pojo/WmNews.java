package com.bdk.model.media.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

import java.util.Date;

/**
* 自媒体图文内容信息表
* @TableName wm_news
*/
@Data
@TableName("wm_news")
public class WmNews implements Serializable {

    /**
    * 主键
    */

    @TableId(value = "id",type = IdType.ID_WORKER)
    private Long id;
    /**
    * 自媒体用户ID
    */
    @TableField("user_id")
    private Integer userId;
    /**
    * 标题
    */
    private String  title;

    private Integer authorId;
    /**
     *
     */

    private String authorName;
    /**
     *
     */

    private Integer channelId;
    /**
     *
     */

    private String channelName;
    /**
     *
     */

    private Integer layout;
    /**
     *
     */

    private Integer flag;
    /**
     *
     */

    private String images;
    /**
     *
     */

    private String labels;
    /**
     *
     */

    private Integer likes;
    /**
     *
     */

    private Integer collection;
    /**
     *
     */

    private Integer comment;
    /**
     *
     */

    private Integer views;
    /**
     *
     */

    private Integer provinceId;
    /**
     *
     */

    private Integer cityId;
    /**
     *
     */

    private Integer countyId;
    /**
     *
     */

    private Date createdTime;
    /**
     *
     */

    private Date publishTime;
    /**
     *
     */

    private Integer syncStatus;
    /**
     *
     */

    private Integer origin;
    /**
     *
     */

    private String staticUrl;

    private String content;

}
