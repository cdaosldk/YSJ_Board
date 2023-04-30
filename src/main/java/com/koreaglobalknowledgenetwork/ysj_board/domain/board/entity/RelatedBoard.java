package com.koreaglobalknowledgenetwork.ysj_board.domain.board.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class RelatedBoard implements Comparable<RelatedBoard> {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  long id;

  String title;

  int relatedWords;

  @Builder
  public RelatedBoard(String title, int relatedWords, Board board) {
    this.title = title;
    this.relatedWords = relatedWords;
    this.board = board;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "board_id")
  private Board board;

  @Override
  public int compareTo(RelatedBoard relatedBoard) {
    return Integer.compare(this.relatedWords, relatedBoard.relatedWords);
  }
}
