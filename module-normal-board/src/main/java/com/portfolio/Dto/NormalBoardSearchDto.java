package com.portfolio.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 일반 게시판(목록)
 date : 2024.09.03
 last_modified: 2024.10.28
 author : 김만기

 ====== Annotation description ======
 Schema: swagger 문서 작성을 위한 annotation

 ====== field description ======


 ====== method description ======


 ====== etc description ======
 Repository에서 Entity가 아닌 Dto로 return 받을 수 있도록 생성자 추가

 */
@Getter
@Setter
public class NormalBoardSearchDto {

    @Schema(description = "게시판 아이디", example = "게시판 아이디")
    private String boardId;
    @Schema(description = "게시판 제목", example = "게시판 제목")
    private String title;
    @Schema(description = "게시판 작성자", example = "게시판 작성자")
    private String firstRegUser;
    @Schema(description = "작성 시간", example = "작성시간")
    private LocalDateTime firstRegTime;


    public NormalBoardSearchDto(String boardId, String title, String firstRegUser, LocalDateTime firstRegTime) {
        this.boardId = boardId;
        this.title = title;
        this.firstRegUser = firstRegUser;
        this.firstRegTime = firstRegTime;
    }

}
