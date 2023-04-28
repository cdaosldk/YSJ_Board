package com.koreaglobalknowledgenetwork.ysj_board.domain.dto;

import lombok.Getter;

@Getter
public class StatusResponseDto {

  private int statusCode;

  private String message;

  public StatusResponseDto(int statusCode, String message) {
    this.statusCode = statusCode;
    this.message = message;
  }
}
