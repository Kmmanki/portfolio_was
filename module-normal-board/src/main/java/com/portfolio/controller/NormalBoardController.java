package com.portfolio.controller;

import com.portfolio.Dto.CreateNormalBoardDto;
import com.portfolio.dto.ApiResultDto;
import com.portfolio.entity.NormalBoard;
import com.portfolio.service.NormalBoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/*
  * 일반 게시판 컨트롤러
  * date: 2024-07-26
  * author: 김만기

  *  ====== Annotation description ======
  * Tag: swagger 문서 작성을 위한 annotation(NormalBoardController를 한 그룹으로 세팅)
  * Operation: swagger 문서 작성을 위한 annotation(메소드별 설명 작성)
 */
@RestController
@RequestMapping("/api/normal-board")
@RequiredArgsConstructor
@Tag(name = "NormalBoard", description = "일반 게시판 관련 API")

public class NormalBoardController {

    private final NormalBoardService normalBoardService;

    @PostMapping("/insert")
    @Operation(summary = "게시물 등록")
    public ResponseEntity<ApiResultDto<NormalBoard>> insertNormalBoard(
       @RequestBody @Validated CreateNormalBoardDto board
    ) {
        ApiResultDto<NormalBoard> result = new ApiResultDto<>();
        try {
            NormalBoard normalBoard = board.toEntity();

            normalBoard.setFirstRegTime(LocalDateTime.now());
            normalBoard.setLastUpdTime(LocalDateTime.now());

            // 로그인 기능이 없기 때문이 임시세팅
            normalBoard.setFirstRegUser("admin");
            normalBoard.setLastUpdUser("admin");

            normalBoardService.insertNormalBoard(normalBoard);
            result.setData(normalBoard);
            result.setResultCode("200");
            result.setResultMessage("Success");
        } catch (Exception e) {
            result.setResultCode("500");
            result.setResultMessage("Fail");
        }

        return new ResponseEntity<>(result, result.getResultCode().equals("200") ? org.springframework.http.HttpStatus.OK
                : org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
