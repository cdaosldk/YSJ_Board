package com.koreaglobalknowledgenetwork.ysj_board.dto;

import java.util.Objects;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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

  public Pageable toPageable() {
    if (Objects.isNull(sortBy)) {
      return PageRequest.of(page, size,
          Sort.by("createdAt").descending()); //sortBy 입력안하면 작성일자 기준으로 내림차순
    } else {
      return PageRequest.of(page, size, Sort.by(sortBy).descending());
    }
  }
}
