package com.dpflsy.hello.controller;

import com.dpflsy.hello.dto.PutRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/put")
public class PutApiController {
    @PutMapping("/put")
    public PutRequestDto put(@RequestBody PutRequestDto requestDto){
        System.out.println(requestDto);
        return requestDto;
    }

    // PathVariable 사용
    // PathVariable 선언한 변수 이름({userId})은 메서드에 선언한 변수와 일치해야함
   @PutMapping("/put02/{userId}")
    public PutRequestDto put02(@RequestBody PutRequestDto requestDto, @PathVariable Long userId){
        System.out.println(userId);
        return requestDto;
    }

    // PathVariable 사용
    // PathVariable 선언한 변수 이름({userId})은 메서드에 선언한 변수와 일치해야함
    // 일치시키지 못하는 상황일 경우 아래와 같이 메소드의 변수를 선언해주면 된다.
    @PutMapping("/put03/{userId}")
    public PutRequestDto put03(@RequestBody PutRequestDto requestDto, @PathVariable(name = "userId") Long id){
        System.out.println(id);
        return requestDto;
    }
}
