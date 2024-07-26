package com.portfolio.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/*
    * API 요청 결과를 담는 DTO
    * date: 2024-07-26
    * author: 김만기
    ====== Annotation description ======
    Schema: swagger 문서 작성을 위한 annotation
 */
@Getter
@Setter
public class ApiResultDto<T> {

    @Schema(description = "결과 코드", example = "200")
    private String resultCode;
    @Schema(description = "결과 메시지", example = "성공")
    private String resultMessage;
    @Schema(description = "추가 데이터")
    private T data;
}
