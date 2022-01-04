package com.hej.book.springboot.config.auth.dto;

import com.hej.book.springboot.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user)
    {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}

/**
 * 굳이 User와 같이 사용하지 않는 이유는 직렬화 에러가 발생하게 됨
 * -> User클래스는 엔티티 클래스로 언제다른 엔티티와 관계가 형성될지 몰라 직렬화 처리는 할 수 없음
 * => 하여 직렬화 기능을 가진 세션 Dto를 하나 추가 하여 사용하는 것이 더 좋음.
 **/