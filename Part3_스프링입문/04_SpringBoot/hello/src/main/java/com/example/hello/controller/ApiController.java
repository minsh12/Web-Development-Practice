package com.example.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// GET에 대한 요청 받는 부분 Controller
@RestController         // 해당 Class는 REST API 처리하는 Controller
@RequestMapping("/api")    // @RequestMapping : URI를 지정해주는 Annotation (주소를 할당해서 매핑)
public class ApiController {

    @GetMapping("/hello")       // http://localhost:8080/api/hello 주소가 매핑
    // RequestMapping과 동일하지만 Get방식으로 동작하게 하려해서 (주소를 할당해서 매핑)
    public String hello() {
        return "hello spring boot!";
    }

    // 8080/api/hello 주소로 GET방식으로 요청이 들어오면 "hello spring boot"란 문자열을 반환할 것
}
