package com.hej.book.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
// spring boot와 Junit사이에 연결자 역할
// 테스트 실행 시 Junit에 내장된 실행자 외에 다른 실행자를 실행시킴킴@WebMvcTest

@WebMvcTest
// Web(Spring MVC)에 집중 할 수 있는 어노테이션

public class HelloControllerTest {

    @Autowired // Bean을 주입받음
    private MockMvc mvc; // WebAPI테스트 시 사용(시작점)_http get,post에 대한 API테스트 진행 가능

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello!";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                    .param("name",name)
                    .param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name)))
                .andExpect(jsonPath("$.amount",is(amount)));
    }

}
