package com.koreaglobalknowledgenetwork.ysj_board.domain.board.service;

import com.koreaglobalknowledgenetwork.ysj_board.domain.board.entity.Board;
import com.koreaglobalknowledgenetwork.ysj_board.domain.board.entity.RelatedBoard;
import com.koreaglobalknowledgenetwork.ysj_board.domain.board.repository.RelatedBoardRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RelatedBoardServiceImpl implements RelatedBoardService {

  // 연관 단어 파악 기준
  private static final double WORD_FREQUENCY_THRESHOLD = 0.4;
  private static final int MIN_RELATED_WORDS_COUNT = 2;

  private final RelatedBoardRepository relatedBoardRepository;

  // 연관 단어 파악 메서드
  @Override
  @Transactional
  public void createRelatedBoard(List<Board> boardList) {
    Map<String, Integer> wordCountMap = new HashMap<>();

    int totalWordCount = 0;

    for (Board board : boardList) {
      for (String word : splitWords(board)) {
        // 게시글별 단어 등장 횟수 계산
        int count = wordCountMap.getOrDefault(word, 0);
        wordCountMap.put(word, count + 1);
        totalWordCount++;
      }
    }

    // 전체 단어 중 자주 사용되는 단어 제외
    Set<String> commonWords = getCommonWords(wordCountMap, totalWordCount);
    wordCountMap.keySet().removeAll(commonWords);

    for (Board board : boardList) {
      List<String> relatedWords = new ArrayList<>();
      String[] words = splitWords(board);

      // 게시글 내 단어별 등장 비중 계산
      Map<String, Double> wordFrequencyMap = new HashMap<>();
      for (String word : words) {
        if (wordCountMap.containsKey(word)) {
          double frequency = (double) wordCountMap.get(word) / totalWordCount;
          wordFrequencyMap.put(word, frequency);
        }
      }

      // 연관단어 리스트에 추가하기
      for (String word : wordCountMap.keySet()) {
        if (wordFrequencyMap.containsKey(word)) {
          double frequency = wordFrequencyMap.get(word);
          if (frequency <= WORD_FREQUENCY_THRESHOLD
              && wordCountMap.get(word) >= MIN_RELATED_WORDS_COUNT) {
            relatedWords.add(word);
          }
        }
      }

      // 조건을 만족하는 relatedBoard 객체를 생성하고 DB에 저장
      if(!relatedWords.isEmpty()) {
        relatedBoardRepository.save(
            RelatedBoard.builder()
                .title(board.getTitle())
                .relatedWords(relatedWords.size())
                .board(board)
                .build());
      }
    }
  }

  // 전체 단어 중 자주 사용되는 단어 제외
  private Set<String> getCommonWords(Map<String, Integer> wordCountMap, int totalWordCount) {
    Set<String> commonWords = new HashSet<>();
    for (String word : wordCountMap.keySet()) {
      double frequency = (double) wordCountMap.get(word) / totalWordCount;
      if (frequency > 0.6) {
        commonWords.add(word);
      }
    }
    return commonWords;
  }

  private String[] splitWords(Board board) {
    return board.getContent().split("\\s+");
  }
}
