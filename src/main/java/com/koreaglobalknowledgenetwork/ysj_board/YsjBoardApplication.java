package com.koreaglobalknowledgenetwork.ysj_board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class YsjBoardApplication {

  public static void main(String[] args) {
    SpringApplication.run(YsjBoardApplication.class, args);
  }

}
