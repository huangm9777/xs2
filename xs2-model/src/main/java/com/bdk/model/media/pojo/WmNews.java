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

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
    * 自媒体用户ID
    */
    @TableField("user_id")
    private Integer userId;
    /**
    * 标题
    */

    private String title;
    /**
    * 图文内容
    */

    private String content;
    /**
    * 文章布局
            0 无图文章
            1 单图文章
            3 多图文章
    */

    private Integer type;
    /**
    * 图文频道ID
    */

    @TableField("channel_id")
    private Integer channelId;
    /**
    * 
    */

    private String labels;
    /**
    * 创建时间
    */

    @TableField("created_time")
    private Date createdTime;
    /**
    * 提交时间
    */

    @TableField("submited_time")
    private Date submitedTime;
    /**
    * 当前状态
            0 草稿
            1 提交（待审核）
            2 审核失败
            3 人工审核
            4 人工审核通过
            8 审核通过（待发布）
            9 已发布
    */

    private Integer status;

    /**
    * 拒绝理由
    */

    private String reason;
    /**
    * //图片用逗号分隔
    */

    private String images;
    /**
    * 
    */

    private Integer enable;

}
