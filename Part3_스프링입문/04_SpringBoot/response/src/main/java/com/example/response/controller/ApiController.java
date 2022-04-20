package com.example.response.controller;

import com.example.response.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    // TEXT
    @GetMapping("/text")
    public String text(@RequestParam String account){
        return account;
    }

    // JSON
    // request오면 -> object mapper를 통해서 -> object로 바뀜 -> 코드의 method를 타고 -> object로 반환 -> object mapper -> json -> response
    @PostMapping("/json")
    public User json(@RequestBody User user) {
        return user;
    }

    @PutMapping("/put")
    public ResponseEntity<User> put(@RequestBody User user){    // ResponseEntity 객체를 통해서 response를 내릴때 http status를 정해줌.
        // 201 status : put으로 요청했을때(리소스가 생성되었을때) 201을 보냄
        return ResponseEntity.status(HttpStatus.CREATED).body(user);    // ResponseEntity에서 httpstatus코드를 지정하고 body에 데이터도 넣어줄 수 O
    }
}
