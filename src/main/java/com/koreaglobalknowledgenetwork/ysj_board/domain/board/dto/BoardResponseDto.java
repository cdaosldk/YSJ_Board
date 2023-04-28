package com.koreaglobalknowledgenetwork.ysj_board.domain.board.dto;

import java.time.LocalDateTime;
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

  public BoardResponseDto(long boardId, String title, String content, LocalDateTime createdAt,
      LocalDateTime modifiedAt) {
    this.boardId = boardId;
    this.title = title;
    this.content = content;
    this.createdAt = createdAt;
    this.modifiedAt = modifiedAt;
  }
}
