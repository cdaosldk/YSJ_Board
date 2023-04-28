package com.koreaglobalknowledgenetwork.ysj_board.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PageDto {

  int page;

  int size;

  String sortBy;

  public PageDto(int page, int size, String sortBy) {
    this.page = page;
    this.size = size;
    this.sortBy = sortBy;
  }
}
