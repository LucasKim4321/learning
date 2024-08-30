package com.test.BoardTest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass // 공동속성처리
@EntityListeners(value={AuditingEntityListener.class})
@Setter@Getter
public class BaseEntity {

    // 엔티티가 생성되어 저장될 때 시간을 자동으로 저장
    @CreatedDate
    @Column(name="reg_date", updatable = false) // updatable=false 수정되는 시점에 기능 off
    private LocalDateTime regDate;

    // 엔티티가 값을 변경될 때 시간을 자동으로 저장
    @LastModifiedDate
    private LocalDateTime modDate;

}
