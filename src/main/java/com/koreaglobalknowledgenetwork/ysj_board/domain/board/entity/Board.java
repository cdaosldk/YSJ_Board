package com.koreaglobalknowledgenetwork.ysj_board.domain.board.entity;

import com.koreaglobalknowledgenetwork.ysj_board.TimeStamped;
import com.koreaglobalknowledgenetwork.ysj_board.domain.board.dto.BoardRequestDto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@NoArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
public class Board extends TimeStamped {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  long id;

  String title;

  String content;

  @Builder
  public Board(long id, String title, String content) {
    this.id = id;
    this.title = title;
    this.content = content;
  }

  @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
  private final List<RelatedBoard> relatedBoards = new ArrayList<>();

  public void update(BoardRequestDto boardRequestDto) {
    this.title = boardRequestDto.getTitle();
    this.content = boardRequestDto.getContent();
  }

  public void sortingRelatedBoards() {
    relatedBoards.stream().sorted(Comparator.comparing(RelatedBoard::getRelatedWords));
  }
}
