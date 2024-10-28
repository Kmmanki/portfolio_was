package com.portfolio.repo;


import com.portfolio.Dto.NormalBoardSearchDto;
import com.portfolio.entity.NormalBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/*
    * date: 2024-07-26
    * author: 김만기
    * JpaRepository를 상속받아 NormalBoard 엔티티를 관리하는 레포지토리
    *
    *   ====== Annotation description ======
    * Query: JPQL을 사용하여 쿼리문 작성
    *  - select new com.portfolio.Dto.NormalBoardSearchDto: NormalBoardSearchDto객체에 매핑
    *  - where board.title like %:#{#board.title}%: searchBoard.title에 해당하는 값을 포함하는 데이터 조회
    *
 */
public interface NormalBoardRepo extends JpaRepository<NormalBoard, String> {

    /*
     * last_modified: 2024-10-28
     */
    @Query("select new com.portfolio.Dto.NormalBoardSearchDto( board.boardId, board.title, board.firstRegUser, board.firstRegTime)  " +
            "from NormalBoard board " +
            "where board.title like %:#{#searchBoard.title}% ")
    Page<NormalBoardSearchDto> findByTitle(NormalBoardSearchDto searchBoard, Pageable pageable);
}
