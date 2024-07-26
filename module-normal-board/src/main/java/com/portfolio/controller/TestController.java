package com.portfolio.controller;

import com.portfolio.entity.NormalBoard;
import com.portfolio.repo.NormalBoardRepo;
import com.portfolio.service.NormalBoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/test")
@RestController
@RequiredArgsConstructor
@Slf4j
@Tag(name = "jpa insert Test")
public class TestController {
    private final NormalBoardService normalBoardService;
    @PostMapping("/jpaInsertTest")

    @Operation(summary = "jpa insert Test")
    public String jpaInsertTest() {

        NormalBoard board = NormalBoard.builder()
                .title("testTitle")
                .content("testContent")
                .firstRegTime(LocalDateTime.now())
                .lastUpdTime(LocalDateTime.now())
                .firstRegUser("patrache")
                .lastUpdUser("patrache")
                .build();

        log.info("controller start");
        normalBoardService.insertNormalBoard(board);
        return board.toString();
    }

    @GetMapping("/jpaSelectTest")
    @Operation(summary = "jpa select Test")
    public List<NormalBoard> jpaSelectTest() {
        List<NormalBoard> boardList = normalBoardService.selectAllBoardList();
        return boardList;
    }
}

