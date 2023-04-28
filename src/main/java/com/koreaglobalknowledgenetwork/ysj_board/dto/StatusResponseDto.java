package com.koreaglobalknowledgenetwork.ysj_board.dto;

import com.koreaglobalknowledgenetwork.ysj_board.enums.ResponseMessages;
import lombok.Getter;

@Getter
public class StatusResponseDto {

  private int statusCode;

  private String message;

  public StatusResponseDto(int statusCode, String message) {
    this.statusCode = statusCode;
    this.message = message;
  }

  public static StatusResponseDto valueOf(ResponseMessages responseMessages) {
    return new StatusResponseDto(responseMessages.getStatusCode(), responseMessages.getMessage());
  }
}
