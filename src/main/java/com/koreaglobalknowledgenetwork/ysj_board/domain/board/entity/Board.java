package com.koreaglobalknowledgenetwork.ysj_board.domain.board.entity;

import com.koreaglobalknowledgenetwork.ysj_board.TimeStamped;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Board extends TimeStamped {

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

  @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<RelatedBoard> relatedBoards = new LinkedHashSet<>();
}
