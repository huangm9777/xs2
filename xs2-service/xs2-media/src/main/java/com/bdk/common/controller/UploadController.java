package com.bdk.common.controller;

import com.bdk.common.utils.AliOssUtil;
import com.bdk.model.common.dto.ResponseResult;
import com.bdk.model.common.enums.AppHttpCodeEnum;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/upload")
@CrossOrigin
@Slf4j
public class UploadController {
    private final AliOssUtil aliOssUtil;


    @PostMapping("/image")
    private ResponseResult uploadImage(MultipartFile file){
        log.info("Uploading file");

        //original file name
        String originalFilename = file.getOriginalFilename();

//        get the file type of the uploading file
        String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));

        String newFileName = UUID.randomUUID().toString() + fileType;

        try {
//            upload to oos


            String url = aliOssUtil.upload(file.getBytes(), newFileName );

            return ResponseResult.okResult(url);
        } catch (IOException e) {

            log.error("FAIL to upload");

            return ResponseResult.errorResult(AppHttpCodeEnum.UPLOAD_FAILED);
        }

    }
}
