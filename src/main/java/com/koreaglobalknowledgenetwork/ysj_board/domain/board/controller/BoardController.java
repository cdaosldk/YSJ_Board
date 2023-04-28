package com.koreaglobalknowledgenetwork.ysj_board.domain.board.controller;

import com.koreaglobalknowledgenetwork.ysj_board.domain.board.dto.BoardResponseDto;
import com.koreaglobalknowledgenetwork.ysj_board.domain.board.dto.PagingBoardResponseDto;
import com.koreaglobalknowledgenetwork.ysj_board.domain.dto.StatusResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BoardController {

  @PostMapping
  public ResponseEntity<StatusResponseDto> createBoard() {
    return null;
  }

  @GetMapping
  public ResponseEntity<BoardResponseDto> getBoard() {
    return null;
  }

  @GetMapping
  public ResponseEntity<Page<PagingBoardResponseDto>> getBoards() {
    return null;
  }

  @PatchMapping
  public ResponseEntity<StatusResponseDto> updateBoard() {
    return null;
  }

  @DeleteMapping
  public ResponseEntity<StatusResponseDto> deleteBoard() {
    return null;
  }
}
