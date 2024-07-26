package com.portfolio.repo;

import com.portfolio.entity.NormalBoard;
import org.springframework.data.jpa.repository.JpaRepository;

/*
    * date: 2024-07-26
    * author: 김만기
    * JpaRepository를 상속받아 NormalBoard 엔티티를 관리하는 레포지토리
 */
public interface NormalBoardRepo extends JpaRepository<NormalBoard, String> {
}
