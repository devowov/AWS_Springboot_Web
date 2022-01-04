package com.hej.book.springboot.config.auth.dto;

import com.hej.book.springboot.domain.user.Role;
import com.hej.book.springboot.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {

    private Map<String,Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    @Builder
    public OAuthAttributes(Map<String,Object> attributes, String nameAttributeKey,
                           String name, String email, String picture)
    {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    // of() : OAuth2User에서 반환하는 사용자 정보가 MAP형태라 하나하나 변환해서 쓰려고 사용
    // API를 판단하여 다른 함수를 실행시켜줌
    public static OAuthAttributes of(String registrationId, String userNameAttributesName, Map<String,Object> attributes)
    {
        if ("naver".equals(registrationId)) {
            return ofNaver("id",attributes);
        }
        return ofGoogle(userNameAttributesName,attributes);
    }

    // 구글
    private static OAuthAttributes ofGoogle(String userNameattributeName, Map<String,Object> attributes)
    {
        return OAuthAttributes.builder()
                .name((String)(attributes.get("name")))
                .email((String)(attributes.get("email")))
                .picture((String)(attributes.get("picture")))
                .attributes(attributes)
                .nameAttributeKey(userNameattributeName)
                .build();
    }

    // 네이버
    private static OAuthAttributes ofNaver(String userNameattributeName, Map<String,Object> attributes)
    {
        Map<String,Object> response = (Map<String,Object>)attributes.get("response");

        return OAuthAttributes.builder()
                .name((String)response.get("name"))
                .email((String)response.get("email"))
                .picture((String)response.get("profileImage"))
                .attributes(response)
                .nameAttributeKey(userNameattributeName)
                .build();
    }

    // User Entity 생성 - 첫 가입 시 생성
    public User toEntity()
    {
        return User.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(Role.GUEST)
                .build();
    }
}
