package com.bdk.media.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bdk.model.common.dto.ResponseResult;
import com.bdk.model.media.dto.WmNewsDto;
import com.bdk.model.media.pojo.WmNews;

public interface MediaService extends IService<WmNews> {


    /**
     *
     * @return
     */
    public ResponseResult listAll();

    /**
     * load newer news
     * @param dto
     * @return
     */
    public ResponseResult load(WmNewsDto dto, Short type);

    /**
     * submit news
     * @param wmNews
     * @return
     */
    public ResponseResult submit(WmNews wmNews);
}
