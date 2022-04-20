package com.example.post.controller;

import com.example.post.dto.PostRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostApiController {

    // 방법1. Map
//    @PostMapping("/post")
//    public void post(@RequestBody Map<String, Object> requestData){
//
//        requestData.forEach((key, value) -> {
//            System.out.println("key : " + key);
//            System.out.println("value : " + value);
//        });
//    }

    // 방법2. dto
    @PostMapping("/post")
    public void post(@RequestBody PostRequestDto requestData){      // post로 들어오는 json데이터를 맵핑하기 위해서는 @RequestBody를 명시해줘야 함
                                                                    // RequestDto 객체를 만들어줘야함
        System.out.println(requestData);
    }
}
