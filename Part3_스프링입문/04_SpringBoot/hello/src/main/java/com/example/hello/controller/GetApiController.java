package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello")    // http://localhost:8080/api/get/hello
    public String getHello() {
        return "get hello";
    }

    // @RequestMapping("/hi")      // get/post/put/delete 모든 메소드에 동작하게 됨 (모든 메소드에 맵핑)
    @RequestMapping(path = "/hi", method = RequestMethod.GET)   // get메소드 지정. http://localhost:8080/api/get/hi
    public String hi() {
        return "hi";
    }

// -----------------------------------------------------------------------------------------------------------------------------------------------
    // #### Path Variable ####

    // http://localhost:8080/api/get/path-variable/{name}
    @GetMapping("/path-variable/{name}")                     // = @GetMapping("/path-variable/{id}")
    public String pathVariable(@PathVariable String name) {     // = public String pathVariable(@PathVariable(name = "id") String pathName)
        System.out.println("PathVariable : " + name);           // = System.out.println("PathVariable : " + pathName);
        return name;                                            // = return pathName;
    }

//    @GetMapping("/path-variable/{name}")
//    // 파라미터 값으로 name이름의 변수가 추가로 사용될 때. name="name"으로 속성을 주면 pathName에 해당 PathVariable에 들은 값({name})이 들어옴
//    public String pathVariable(@PathVariable(name = "name") String pathName, String name) {
//        System.out.println(("PathVariable : " + pathName));
//        return pathName;
//    }


// ----------------------------------------------------------------------------------------------------------------------------------------------------------
    // #### Query Parameter ####

    // 방법1. 어떤 데이터가 들어올지 모를때 Map 활용
    // http://localhost:8080/api/get/query-param?user=steve&email=steve@gmail.com&age=30
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {        // 데이터의 형태가 key, value라서 Map으로 데이터 받음
        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
        });

        return sb.toString();
    }

    // 방법2. 쿼리파라미터로 들어오는 종류가 적으면 이렇게 받아도 괜찮음
    @GetMapping("query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ) {
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name + " " + email + " " + age;
    }

    // 방법3. Request dto에 객체를 만들어서 쿼리 파라미터가 바로 맵핑되도록 하는 방법 (가장 많이 사용)
    // ?user=steve&email=steve@gmail.com&age=30     미리 쿼리파라미터에 대해 정의를 해두면 객체를 만들어서 받는 형태가 가장 편리
    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest) {    // 파라미터의 key에 해당하는 변수를 객체(UserRequest)에서 변수와 이름을 매칭함
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }

}
