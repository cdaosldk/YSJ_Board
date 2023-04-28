package com.koreaglobalknowledgenetwork.ysj_board.domain.board.controller;

import static com.koreaglobalknowledgenetwork.ysj_board.util.HttpResponseEntity.RESPONSE_OK;

import com.koreaglobalknowledgenetwork.ysj_board.domain.board.dto.BoardRequestDto;
import com.koreaglobalknowledgenetwork.ysj_board.domain.board.dto.BoardResponseDto;
import com.koreaglobalknowledgenetwork.ysj_board.domain.board.dto.PagingBoardResponseDto;
import com.koreaglobalknowledgenetwork.ysj_board.domain.board.service.BoardService;
import com.koreaglobalknowledgenetwork.ysj_board.dto.StatusResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

  private final BoardService boardService;

  @PostMapping
  public ResponseEntity<StatusResponseDto> createBoard(@RequestBody BoardRequestDto boardRequestDto) {
    boardService.createBoard(boardRequestDto);
    return RESPONSE_OK;
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
