package com.koreaglobalknowledgenetwork.ysj_board.domain.board.controller;

import static com.koreaglobalknowledgenetwork.ysj_board.util.HttpResponseEntity.RESPONSE_CREATED;
import static com.koreaglobalknowledgenetwork.ysj_board.util.HttpResponseEntity.RESPONSE_DELETE;
import static com.koreaglobalknowledgenetwork.ysj_board.util.HttpResponseEntity.RESPONSE_OK;

import com.koreaglobalknowledgenetwork.ysj_board.domain.board.dto.BoardRequestDto;
import com.koreaglobalknowledgenetwork.ysj_board.domain.board.dto.BoardResponseDto;
import com.koreaglobalknowledgenetwork.ysj_board.domain.board.dto.PagingBoardResponseDto;
import com.koreaglobalknowledgenetwork.ysj_board.domain.board.service.BoardService;
import com.koreaglobalknowledgenetwork.ysj_board.dto.PageDto;
import com.koreaglobalknowledgenetwork.ysj_board.dto.StatusResponseDto;
import com.koreaglobalknowledgenetwork.ysj_board.util.SetHttpHeaders;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

  private final BoardService boardService;

  private final SetHttpHeaders setHttpHeaders;


  @PostMapping
  public ResponseEntity<StatusResponseDto> createBoard(@RequestBody BoardRequestDto boardRequestDto) {
    boardService.createBoard(boardRequestDto);
    return RESPONSE_CREATED;
  }

  @GetMapping("/{boardId}")
  public ResponseEntity<BoardResponseDto> getBoard(@PathVariable long boardId) {
    return ResponseEntity.ok().headers(setHttpHeaders.setHeaderTypeJson()).body(boardService.getBoard(boardId));
  }

  @GetMapping
  public ResponseEntity<Page<PagingBoardResponseDto>> getBoards(@ModelAttribute PageDto pageDto) {
    return ResponseEntity.ok().body(boardService.getBoards(pageDto));
  }

  @PatchMapping("/{boardId}")
  public ResponseEntity<StatusResponseDto> updateBoard(@PathVariable long boardId) {
    boardService.updateBoard(boardId);
    return RESPONSE_OK;
  }

  @DeleteMapping("/{boardId}")
  public ResponseEntity<StatusResponseDto> deleteBoard(long boardId) {
    boardService.deleteBoard(boardId);
    return RESPONSE_DELETE;
  }
}
