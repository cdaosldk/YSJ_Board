package com.koreaglobalknowledgenetwork.ysj_board.domain.board.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PagingBoardResponseDto {

  private String title;

  private LocalDateTime createdAt;

  private LocalDateTime modiefiedAt;

  @Builder
  public PagingBoardResponseDto(String title, LocalDateTime createdAt, LocalDateTime modiefiedAt) {
    this.title = title;
    this.createdAt = createdAt;
    this.modiefiedAt = modiefiedAt;
  }
}
