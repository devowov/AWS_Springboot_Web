package com.hej.book.springboot.web;

import com.hej.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // Json을 반환하는 컨트롤러 생성
                // @ResponseBody를 메소드 마다 선언했던 것 단일화
public class HelloController {

    @GetMapping("/hello") // @RequestMapping
    public String Hello()
    {
        return "hello!";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                        @RequestParam("amount") int amount)
    {
        return new HelloResponseDto(name,amount);
    }
}
