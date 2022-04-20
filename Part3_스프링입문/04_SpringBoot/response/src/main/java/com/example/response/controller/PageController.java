package com.example.response.controller;

import com.example.response.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller     // : html페이지 리소스를 찾음
public class PageController {

    @RequestMapping("/main")
    public String main() {
        return "main.html";     // @Controller는 String을 리턴하게 되면 리소스를 찾음
    }


    /* 페이지 컨트롤러에서 데이터보내는 방법이지만, ApiController에서 주로 보내지 이렇게 잘 사용X. 여기선 html리턴만 주로 함.
    // Json 방법1. ResponseEntity
    // Json 방법2
    @ResponseBody   // @Controller-@ResponseBody 붙여주면, html리소스 안찾고 ResponseBody를 만들어 내림 -> Json으로 객체를 내려줌
    @GetMapping("/user")
    public User user() {
        var user = new User();
        user.setName("min");
        user.setAddress("패스트캠퍼스");
        return user;
    }
     */
}
