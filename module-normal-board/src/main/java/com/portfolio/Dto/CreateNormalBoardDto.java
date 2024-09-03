package com.portfolio.Dto;

import com.portfolio.entity.NormalBoard;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


/**
 * 일반 게시판 생성 DTO
 date : 2024.07.26
 author : 김만기

 ====== Annotation description ======
 Schema: swagger 문서 작성을 위한 annotation

 Validation 관련 Annotation(조건에 부합하지않느다면 MethodArgumentNotValidException 발생)
    NotBlank: null, "" 체크
    Size: 길이 체크

 ====== field description ======
 title: 게시판 제목
 content: 게시판 내용

 ====== method description ======
 toEntity: DTO를 DB에 적재하기 위한 Entity로 변환

 ====== etc description ======
 entity를 사용하고 싶었으나 entity를 사용하면 Swagger의 example Value가 모든 필드를 표기하는 문제가 있어서 DTO를 사용

 */
@Getter
@Setter
public class CreateNormalBoardDto {
    @Schema(description = "게시판 제목", example = "게시판 제목")
    @NotBlank(message = "제목은 필수 입니다.")
    @Size(max = 30, message = "제목은 최대 30자 입니다.")
    private String title;

    @Schema(description = "게시판 내용", example = "게시판 내용")
    @NotBlank(message = "내용은 필수 입니다.")
    private String content;

    public NormalBoard toEntity() {
        return NormalBoard.builder()
                .title(title)
                .content(content)
                .build();
    }
}
