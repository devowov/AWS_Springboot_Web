package com.hej.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 메인 클래스 ** 항상 프로젝트 최상단에 위치해 있어야 함.

@SpringBootApplication // springboot의 자동 설정 ,Bean읽기 및 생성 자동화
public class Application {
    public static void main(String[] args) {
        // 내장 Was실행
        SpringApplication.run(Application.class,args);
    }
}
