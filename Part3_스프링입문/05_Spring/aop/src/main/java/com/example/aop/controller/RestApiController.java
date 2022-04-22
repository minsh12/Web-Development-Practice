package com.example.aop.controller;

import com.example.aop.annotation.Decode;
import com.example.aop.annotation.Timer;
import com.example.aop.dto.User;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name) {
//        System.out.println(("get method"));
//        System.out.println(("get method : " + id));
//        System.out.println(("get method" + name));
        return id + " " + name;
    }

    @PostMapping("/post")
    public User post(@RequestBody User user) {
//        System.out.println("post method : " + user);
        return user;
    }

    @Timer  // 직접 만든 어노테이션
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException {

//        (AOP가 없었다면) 로직이 들어가야 할 곳에 기능관련없는 부가적인 코드들이 들어가게 됨 -> AOP로 처리
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();

        /* 이렇게 메소드의 시간을 재는 것은
        * 복잡한 로직이 있거나 DB를 사용하거나 외부기관과 통신을 할때 등에 시간소요를 측정.
        * 이때, AOP를 통해서 Timer 어노테이션만 붙이면, 비즈니스로직쪽에 코드 구현할 필요없이
        * AOP가 알아서 시간 로그를 남기거나 db에 저장하거나 모니터링하는 쪽에 푸시를 하는 등의 역할을 수행할 수 O*/
        // db logic 처리하는데 2초 소요 전제
        Thread.sleep(1000 * 2);

//        stopWatch.stop();
//        System.out.println("total time : " + stopWatch.getTotalTimeSeconds());
    }

    @Decode
    @PutMapping("/put")
    public User put(@RequestBody User user) {
        System.out.println("put");
        System.out.println(user);
        return user;
    }
}
