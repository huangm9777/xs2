package com.bdk.media.controller;

import com.bdk.media.service.MediaService;
import com.bdk.model.common.dto.ResponseResult;
import com.bdk.model.common.enums.NewsConstants;
import com.bdk.model.media.dto.WmNewsDto;
import com.bdk.model.media.pojo.WmNews;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class MediaController {

    private final MediaService mediaService;

    /**
     * list all new, for test purpose
     * @return
     */
    @GetMapping("/media/listAll")
    public ResponseResult listAll(){
        return mediaService.listAll();
    }

    @PostMapping("/media/listnew")
    public  ResponseResult loadNew(@RequestBody WmNewsDto dto){
        return mediaService.load(dto, NewsConstants.LOADTYPE_LOAD_NEW);
    }
    @PostMapping("/media/listmore")
    public  ResponseResult loadMore(@RequestBody WmNewsDto dto){
        return mediaService.load(dto, NewsConstants.LOADTYPE_LOAD_MORE);
    }

    @PostMapping("/media/submit")
    public ResponseResult submit(@RequestBody WmNews wmNews){
        return mediaService.submit(wmNews);
    }

}
