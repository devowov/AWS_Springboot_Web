package com.hej.book.springboot.dto;

import com.hej.book.springboot.web.dto.HelloResponseDto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
// -> Junit이 아닌 assertj만의 장점이 있음
// -> 추가적인 라이브러리 불필요, 자동완성이 좀 더 확실함.

public class HelloResponseDtoTest {

    @Test
    public void 롬복_리능_테스트(){
        // given
        String name = "test";
        int amount = 1000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name,amount);

        // then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);

        // assertThan -> 테스트 검증 라이브러리의 검증 메소드
        // 검증하고 싶은 대상을 메소드 인자로 받음
    }
}
