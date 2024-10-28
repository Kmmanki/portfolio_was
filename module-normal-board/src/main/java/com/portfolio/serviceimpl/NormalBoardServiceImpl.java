package com.portfolio.serviceimpl;

import com.portfolio.Dto.NormalBoardSearchDto;
import com.portfolio.entity.NormalBoard;
import com.portfolio.repo.NormalBoardRepo;
import com.portfolio.service.NormalBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
/*
    * 일반 게시판 서비스 구현체
    * date: 2024-07-26
    * last_modified: 2024-10-28
    * author: 김만기
    *
    * ====== Annotation description ======
    * Service: 서비스 빈으로 등록
    *
    * ====== method description ======
    * insertNormalBoard: 일반 게시판 등록
    * selectAllBoardList: 모든 게시판 조회
    * selectNormalBoardTitles: 게시판 제목 조회
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class NormalBoardServiceImpl implements NormalBoardService {
    private final NormalBoardRepo boardRepo;

    @Override
    public void insertNormalBoard(NormalBoard board) {
        boardRepo.save(board);
    }

    @Override
    public List<NormalBoard> selectAllBoardList() {
        return boardRepo.findAll();
    }

    /**
     * 게시판 제목 조회
     * date 2024.10.28
     * last_modified 2024.10.28
     */
    @Override
    public Page<NormalBoardSearchDto> selectNormalBoardTitles(NormalBoardSearchDto board, Pageable pageable) {
        return boardRepo.findByTitle(board, pageable);
    }
}
