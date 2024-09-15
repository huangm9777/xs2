package com.bdk.media.controller;

import com.bdk.media.service.MediaService;
import com.bdk.model.common.dto.ResponseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MediaController {

    private final MediaService mediaService;

    @GetMapping("/media/listAll")
    public ResponseResult listAll(){
        return mediaService.listAll();

    }
}
