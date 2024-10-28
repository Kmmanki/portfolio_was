package com.portfolio.service;

import com.portfolio.Dto.NormalBoardSearchDto;
import com.portfolio.entity.NormalBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
/*
    * 일반 게시판 서비스 인터페이스
    * date: 2024-07-26
    * last_modified: 2024-10-28
    * author: 김만기
    ====== method description ======
    * insertNormalBoard: 일반 게시판 등록
    * selectAllBoardList: 모든 게시판 조회
    * selectNormalBoardTitles: 게시판 제목 조회
 */
public interface NormalBoardService {
    public void insertNormalBoard(NormalBoard board);

    public List<NormalBoard> selectAllBoardList();

    /**
     * 게시판 제목 조회
     * date 2024.10.28
     * last_modified 2024.10.28
     */
    public Page<NormalBoardSearchDto> selectNormalBoardTitles(NormalBoardSearchDto board, Pageable pageable);
}
