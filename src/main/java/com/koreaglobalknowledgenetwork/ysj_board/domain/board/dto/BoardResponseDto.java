package com.koreaglobalknowledgenetwork.ysj_board.domain.board.dto;

import com.koreaglobalknowledgenetwork.ysj_board.domain.board.entity.Board;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardResponseDto {

  private long boardId;

  private String title;

  private String content;

  private LocalDateTime createdAt;

  private LocalDateTime modifiedAt;

  public BoardResponseDto(Board board) {
    this.boardId = board.getId();
    this.title = board.getTitle();
    this.content = board.getContent();
    this.createdAt = board.getCreatedAt();
    this.modifiedAt = board.getModifiedAt();
  }
}
