package com.koreaglobalknowledgenetwork.ysj_board.domain.board.entity;

import com.koreaglobalknowledgenetwork.ysj_board.TimeStamped;
import com.koreaglobalknowledgenetwork.ysj_board.domain.board.dto.BoardRequestDto;
import java.util.LinkedHashSet;
import java.util.Set;
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
  private final Set<RelatedBoard> relatedBoards = new LinkedHashSet<>();

  public void update(BoardRequestDto boardRequestDto) {
    this.title = boardRequestDto.getTitle();
    this.content = boardRequestDto.getContent();
  }
}
