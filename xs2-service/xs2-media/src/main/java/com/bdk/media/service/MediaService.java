package com.bdk.media.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bdk.model.common.dto.ResponseResult;
import com.bdk.model.media.pojo.WmNews;

public interface MediaService extends IService<WmNews> {


    public ResponseResult listAll();
}
