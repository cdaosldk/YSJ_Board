package com.koreaglobalknowledgenetwork.ysj_board.domain.board.service;

import com.koreaglobalknowledgenetwork.ysj_board.domain.board.entity.Board;
import com.koreaglobalknowledgenetwork.ysj_board.domain.board.entity.RelatedBoard;
import java.util.List;
import java.util.Optional;

public interface RelatedBoardService {

  void createRelatedBoard(List<Board> boardList);
}
