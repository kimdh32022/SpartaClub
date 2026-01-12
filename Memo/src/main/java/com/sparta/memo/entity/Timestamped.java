package com.sparta.memo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPA Entity 클래스들이 해당 클래스를 상속할 경우 추상클래스에 선언한 멤버 변수를 Column으로 인식하게 함.
@EntityListeners(AuditingEntityListener.class) // 해당 클래스의 auditing 기능을 포함한다.
public abstract class Timestamped {

    @CreatedDate // Entity 객체가 생성될때 자동으로 저장됨.
    @Column(updatable = false) // 변경되지 않게 업데이트 막음.
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @LastModifiedDate // 변경이 생길때 마다 자동으로 저장됨.
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime modifiedAt;

// Temporal 옵션 타입
//    Date : 2026-01-12
//    DateTime : 11:54:02
//    TimeSTAMP : 2026-01-12 11:54:02.9999395

}
