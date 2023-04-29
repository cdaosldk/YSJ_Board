package com.koreaglobalknowledgenetwork.ysj_board.domain.board.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RelatedBoard {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  long id;


}
