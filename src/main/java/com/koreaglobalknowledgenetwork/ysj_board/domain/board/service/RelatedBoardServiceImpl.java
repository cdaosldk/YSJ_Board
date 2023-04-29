package com.koreaglobalknowledgenetwork.ysj_board.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RelatedBoardServiceImpl implements RelatedBoardService{

  @Override
  public void findRelatedPost() {

  }

  private int countCommonWords() {
    return 0;
  }

  private int countUncommonWords() {
    return 0;
  }
}
