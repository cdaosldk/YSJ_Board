package com.koreaglobalknowledgenetwork.ysj_board.domain.board.service;

import com.koreaglobalknowledgenetwork.ysj_board.domain.board.entity.Board;
import java.util.List;

public interface RelatedBoardService {

  void createRelatedBoard(List<Board> boardList);
}
