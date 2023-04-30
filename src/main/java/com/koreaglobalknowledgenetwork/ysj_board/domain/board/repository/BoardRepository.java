package com.koreaglobalknowledgenetwork.ysj_board.domain.board.repository;

import com.koreaglobalknowledgenetwork.ysj_board.domain.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
