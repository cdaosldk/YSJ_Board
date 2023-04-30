package com.koreaglobalknowledgenetwork.ysj_board.domain.board.service;

import com.koreaglobalknowledgenetwork.ysj_board.domain.board.entity.Board;
import java.util.Optional;

public interface RelatedBoardService {

  void findRelatedBoard(Board board);

  void sortingRelatedBoard();

}
