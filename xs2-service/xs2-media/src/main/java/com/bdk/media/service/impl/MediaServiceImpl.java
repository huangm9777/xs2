package com.bdk.media.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bdk.media.mapper.MediaMapper;
import com.bdk.media.service.MediaService;
import com.bdk.model.common.dto.ResponseResult;
import com.bdk.model.common.enums.AppHttpCodeEnum;
import com.bdk.model.common.enums.NewsConstants;
import com.bdk.model.media.dto.WmNewsDto;
import com.bdk.model.media.pojo.WmNews;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MediaServiceImpl extends ServiceImpl<MediaMapper, WmNews> implements MediaService {

    private final static Short MAX_PAGE_SIZE = 10;

    private final MediaMapper mediaMapper;
    @Override
    public ResponseResult listAll() {
        List<WmNews> list = lambdaQuery().list();
        return ResponseResult.okResult(list);
    }

    /**
     * load newer news
     * @param dto
     * @return
     */
    @Override
    public ResponseResult load(WmNewsDto dto,Short type) {
        // 1.validate param
        // validate page size
        Integer size = dto.getSize();
        if(size == null || size==0){
            size = 10;
        }
        size = Math.min(size, MAX_PAGE_SIZE);
        dto.setSize(size);

        //validate type paramxs2_media.wm_new.publish_time
        if (!type.equals(NewsConstants.LOADTYPE_LOAD_MORE)&&!type.equals(NewsConstants.LOADTYPE_LOAD_NEW)){
            type = NewsConstants.LOADTYPE_LOAD_MORE;
        }

        // validate tag id

        if (StringUtils.isBlank(dto.getTag()) ){
            dto.setTag(NewsConstants.DEFAULT_TAG);
        }

        //validate time
        if(dto.getMaxBehotTime() == null)dto.setMaxBehotTime(new Date());
        if(dto.getMinBehotTime() == null)dto.setMinBehotTime(new Date());

        //query
//        List<ApArticle> apArticles = apArticleMapper.loadArticleList(dto, type);
        List<WmNews> wmNewsList = mediaMapper.loadArticleList(dto, type);
//        List<WmNews> wmNewsList = lambdaQuery().lt(WmNews::getSubmitedTime, dto.getMinBehotTime()).gt(WmNews::getSubmitedTime, dto.getMaxBehotTime()).list();

        return ResponseResult.okResult(wmNewsList);

    }


    /**
     * submit news
     * @param wmNews
     * @return
     */
    @Override
    public ResponseResult submit(WmNews wmNews) {
        //check param
        if (wmNews == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        if (wmNews.getContent()==null&& wmNews.getImages()==null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        //TODO
        wmNews.setAuthorId(1101);
//        wmNews.setUserId(1101);
        wmNews.setChannelId(0);
        wmNews.setAuthorName("admin");
        wmNews.setCreatedTime(new Date());
        wmNews.setPublishTime(new Date());


        save(wmNews);



        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }


}
