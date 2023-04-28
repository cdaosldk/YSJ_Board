package com.koreaglobalknowledgenetwork.ysj_board.util;

import com.koreaglobalknowledgenetwork.ysj_board.enums.ResponseMessages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.koreaglobalknowledgenetwork.ysj_board.dto.StatusResponseDto;

public class HttpResponseEntity {

  public static final ResponseEntity<StatusResponseDto> RESPONSE_OK = ResponseEntity
      .status(HttpStatus.OK).body(StatusResponseDto.valueOf(
          ResponseMessages.SUCCESS));

  public static final ResponseEntity<StatusResponseDto> RESPONSE_CREATED = ResponseEntity.status(
      HttpStatus.CREATED).build();

  public static final ResponseEntity<StatusResponseDto> RESPONSE_DELETE = ResponseEntity.status(
      HttpStatus.NO_CONTENT).build();

}
