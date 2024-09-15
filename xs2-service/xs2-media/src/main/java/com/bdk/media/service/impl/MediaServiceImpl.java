package com.bdk.media.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bdk.media.mapper.MediaMapper;
import com.bdk.media.service.MediaService;
import com.bdk.model.common.dto.ResponseResult;
import com.bdk.model.media.pojo.WmNews;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaServiceImpl extends ServiceImpl<MediaMapper, WmNews> implements MediaService {
    @Override
    public ResponseResult listAll() {
        List<WmNews> list = lambdaQuery().list();
        return ResponseResult.okResult(list);
    }
}
