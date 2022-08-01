package com.dpflsy.hello.controller;

import com.dpflsy.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path="/hello")   // http://localhost:9090/api/get/hello
    public String getHello(){
        return "get Hello!";
    }

    // 예전에 쓰던 방식
    // @RequstMapping(path="/hi")만 쓰게 될 경우 GET/POST/PUT/DELETE에 모두 쓰이게 되므로 Method를 별도로 지정해준다
    @RequestMapping(path="/hi", method= RequestMethod.GET) // GET http://localhost:9090/api/get/hi
    public String hi() {
        return "hi";
    }

    // Path Variable
    // http://localhost:9090/api/get/path-variable/{name}
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable(name="name") String pathName){
        System.out.println("PathVariable : "+ pathName);
        return pathName;
    }

    // queryParameter
    // ?key=value&key2=value2 형식으로 붙어옴
    // http://localhost:9090/api/get/query-param?user=dpflsy&email=dpflsy@naver.com&age=28
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {
        StringBuilder sb = new StringBuilder();

        // 람다식으로 받음
        queryParam.entrySet().forEach( entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
        });

        return sb.toString();
    }

    // queryParameter를 명시적으로 받는 방법
    @GetMapping("query-param02")
    public String queryParam02 (
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ) {
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name + " " + email + " " + age;
    }

    // 현업에서 많이쓰는 방법
    // DTO를 생성해준 후 아래와 같이 메소드를 추가해준다
    @GetMapping("query-param03")
    public String queryParam03 (UserRequest userRequest) {
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }
}
