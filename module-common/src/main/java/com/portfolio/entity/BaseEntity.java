package com.portfolio.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

/*
    * date : 2024.07.26
    * author : 김만기
    * Base Entity: 모든 엔티티의 공통 필드를 정의한 추상 클래스

    * ====== Annotation description ======
    MappedSuperclass: jpa에서 상속 시 상속 받은 값들을 컬럼으로 사용하기 위함
    SuperBuilder: extends한 클레스에 builder를 사용하기 위함
    Column: 컬럼명, 길이, notNull 등의 설정

    * ====== field description ======
    firstRegTime: 최초 등록 시간
    lastUpdTime: 마지막 수정 시간
    firstRegUser: 최초 등록 사용자
    lastUpdUser: 마지막 수정 사용자
 */

@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class BaseEntity {
    @Column(nullable = false)
    LocalDateTime firstRegTime;
    @Column(nullable = false)
    LocalDateTime lastUpdTime;
    @Column(length = 15, nullable = false)
    String firstRegUser;
    @Column(length = 15, nullable = false)
    String lastUpdUser;
}

