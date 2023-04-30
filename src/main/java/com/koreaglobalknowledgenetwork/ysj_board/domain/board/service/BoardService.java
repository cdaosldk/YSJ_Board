package com.koreaglobalknowledgenetwork.ysj_board.domain.board.service;

import com.koreaglobalknowledgenetwork.ysj_board.domain.board.dto.BoardRequestDto;
import com.koreaglobalknowledgenetwork.ysj_board.domain.board.dto.BoardResponseDto;
import com.koreaglobalknowledgenetwork.ysj_board.domain.board.dto.PagingBoardResponseDto;
import com.koreaglobalknowledgenetwork.ysj_board.dto.PageDto;
import org.springframework.data.domain.Page;

public interface BoardService {

  void createBoard(BoardRequestDto boardRequestDto);

  BoardResponseDto getBoard(long boardId);

  Page<BoardResponseDto> getBoards(PageDto pageDto);

  void updateBoard(long boardId, BoardRequestDto boardRequestDto);

  void deleteBoard(long boardId);

}
