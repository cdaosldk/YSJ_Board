package com.koreaglobalknowledgenetwork.ysj_board.domain.board.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Board {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  Long id;

  String title;

  String content;

  public Board(Long id, String title, String content) {
    this.id = id;
    this.title = title;
    this.content = content;
  }
}
