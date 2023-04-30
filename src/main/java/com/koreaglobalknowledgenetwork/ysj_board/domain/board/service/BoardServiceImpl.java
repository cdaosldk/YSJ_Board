package com.koreaglobalknowledgenetwork.ysj_board.domain.board.service;

import com.koreaglobalknowledgenetwork.ysj_board.domain.board.dto.BoardRequestDto;
import com.koreaglobalknowledgenetwork.ysj_board.domain.board.dto.BoardResponseDto;
import com.koreaglobalknowledgenetwork.ysj_board.domain.board.entity.Board;
import com.koreaglobalknowledgenetwork.ysj_board.domain.board.repository.BoardRepository;
import com.koreaglobalknowledgenetwork.ysj_board.dto.PageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

  private final RelatedBoardService relatedBoardService;

  private final BoardRepository boardRepository;

  @Override
  @Transactional
  public void createBoard(BoardRequestDto boardRequestDto) {
    boardRepository.save(Board.builder()
        .title(boardRequestDto.getTitle())
        .content(boardRequestDto.getContent())
        .build());
  }

  @Override
  public BoardResponseDto getBoard(long boardId) {
    Board board = findBoardById(boardId);
    relatedBoardService.findRelatedBoard(board);

    return new BoardResponseDto(board);
  }

  @Override
  public Page<BoardResponseDto> getBoards(PageDto pageDto) {
    return boardRepository.findAll(pageDto.toPageable()).map(BoardResponseDto::new);
  }

  @Override
  @Transactional
  public void updateBoard(long boardId, BoardRequestDto boardRequestDto) {
    findBoardById(boardId).update(boardRequestDto);
  }

  @Override
  @Transactional
  public void deleteBoard(long boardId) {
    boardRepository.deleteById(boardId);
  }

  private Board findBoardById(long boardId) {
    return boardRepository.findById(boardId).orElseThrow(
        () -> new IllegalArgumentException("존재하지 않는 게시물입니다.")
    );
  }
}
