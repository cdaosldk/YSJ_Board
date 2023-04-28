package com.koreaglobalknowledgenetwork.ysj_board.domain.board.service;

import com.koreaglobalknowledgenetwork.ysj_board.domain.board.dto.BoardRequestDto;
import com.koreaglobalknowledgenetwork.ysj_board.domain.board.dto.BoardResponseDto;
import com.koreaglobalknowledgenetwork.ysj_board.domain.board.dto.PagingBoardResponseDto;
import org.springframework.data.domain.Page;

public interface BoardService {

  void createBoard(BoardRequestDto boardRequestDto);

  BoardResponseDto getBoard();

  Page<PagingBoardResponseDto> getBoards();

  void updateBoard();

  void deleteBoard();

}
