package com.dpflsy.hello.controller;

import com.dpflsy.hello.dto.PostRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/post")
public class PostApiController {
    @PostMapping("/post")
    public void post(@RequestBody Map<String, Object> requestData) {
        requestData.forEach((key, value) -> {
            System.out.println("key : " + key);
            System.out.println("value : " + value);
        });
    }

    // 값을 받아주는 방법
    // Dto 작성
    @PostMapping("/post02")
    public void post02(@RequestBody PostRequestDto postRequestDto) {
        System.out.println(postRequestDto);
    }
}
