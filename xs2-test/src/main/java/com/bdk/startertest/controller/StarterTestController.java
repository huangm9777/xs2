package com.bdk.startertest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StarterTestController {

    @GetMapping("/test/hello")
    public String hello(){
        return "hello from starter test";
    }
}
