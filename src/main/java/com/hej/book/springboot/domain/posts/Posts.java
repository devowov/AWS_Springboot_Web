package com.hej.book.springboot.domain.posts;

import com.hej.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor // 기본생성자 자동 추가
@Entity
public class Posts extends BaseTimeEntity { // 실제 DB의 테이블과 매칭될 클래스(= Entity클래스) ,  Setter없음(절대 안만듬) -> 값은 메소드를 이용하여 삽입

    @Id // PK -> auto_increment권장
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 기본값은 VARCHAR(255)
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content,String author)
    {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
