package com.hej.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

// 해당 클래스는 모든 Entity클래스의 상위클래스가 되어 생성/수정 시간을 자동으로 관리해주게 됨.

@Getter
@MappedSuperclass // 해당 클래스를 상속받는 경우 하위 변수들을 컬럼으로 인식하게 해줌.
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @CreatedDate // Entity가 생성되어 저장되는 시간
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
