package com.portfolio.service;

import com.portfolio.entity.NormalBoard;

import java.util.List;
/*
    * 일반 게시판 서비스 인터페이스
    * date: 2024-07-26
    * author: 김만기
    ====== method description ======
    * insertNormalBoard: 일반 게시판 등록
 */
public interface NormalBoardService {
    public void insertNormalBoard(NormalBoard board);

    public List<NormalBoard> selectAllBoardList();
}
