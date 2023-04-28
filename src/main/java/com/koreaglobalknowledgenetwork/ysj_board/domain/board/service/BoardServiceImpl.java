package com.koreaglobalknowledgenetwork.ysj_board.domain.board.service;

import com.koreaglobalknowledgenetwork.ysj_board.domain.board.dto.BoardRequestDto;
import com.koreaglobalknowledgenetwork.ysj_board.domain.board.dto.BoardResponseDto;
import com.koreaglobalknowledgenetwork.ysj_board.domain.board.dto.PagingBoardResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

  @Override
  public void createBoard(BoardRequestDto boardRequestDto) {

  }

  @Override
  public BoardResponseDto getBoard() {
    return null;
  }

  @Override
  public Page<PagingBoardResponseDto> getBoards() {
    return null;
  }

  @Override
  public void updateBoard() {

  }

  @Override
  public void deleteBoard() {

  }
}
