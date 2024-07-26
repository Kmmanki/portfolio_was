package com.portfolio.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


/**
 * 일반 게시판 Entity
 * date : 2024.07.26
 * author : 김만기

 ====== Annotation description ======
 Entity: JPA Entity로 선언
 SuperBuilder: 상속 받는 값을을 builder로 사용하기위해 필요
 Table: 테이블 명을 클래스명과 별도로 세팅, index 설정
 Id: pk로 사용할 변수 선언
 GeneratedValue: pk값 자동생성 전략을 선택
 Column: 컬럼명, 길이, notNull 등의 설정

 ====== field description ======
 boardId: 게시판 아이디
 title: 게시판 제목
 content: 게시판 내용
 */

@Entity
@Getter
@Setter
@SuperBuilder
@Table(name = "tbl_normal_board", indexes =
        @Index(name = "tbl_normal_board_idx_01", columnList = "first_reg_time")
)
@NoArgsConstructor
@AllArgsConstructor

public class NormalBoard extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String boardId;

    @Column(length = 30, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
}
