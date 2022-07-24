package com.example.week01secondt.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass// 상속했을때 컬럼으로 인식
@EntityListeners(AuditingEntityListener.class) // Entity를 follow하면서 변화를 본다.
// AuditingEntityListener = 뭔가 변화가 생기면 자동으로 변경요청 modifiedAt을 쓸때 활용
public abstract class Timestamped { // abstract 상속했을때만 쓸수 있다.

    @CreatedDate // 생성일자임을 알려줌
    private LocalDateTime createdAt;

    @LastModifiedDate // 변경된 일자를 알려줌
    private LocalDateTime modifiedAt;
}
