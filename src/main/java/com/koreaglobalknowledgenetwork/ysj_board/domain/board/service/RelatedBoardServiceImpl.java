package com.koreaglobalknowledgenetwork.ysj_board.domain.board.service;

import com.koreaglobalknowledgenetwork.ysj_board.domain.board.entity.Board;
import com.koreaglobalknowledgenetwork.ysj_board.domain.board.repository.BoardRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RelatedBoardServiceImpl implements RelatedBoardService{

  // 연관 단어 파악 기준
  private static final double WORD_FREQUENCY_THRESHOLD = 0.4;
  private static final int MIN_RELATED_WORDS_COUNT = 2;

  private final BoardRepository boardRepository;

  // 연관 단어 파악 메서드
  @Override
  @Transactional
  public void findRelatedBoard(Board board) {
    Map<String, Integer> wordCountMap = new HashMap<>();
    Map<String, Double> wordFrequencyMap = new HashMap<>();
    List<String> relatedWords = new ArrayList<>();
    Map<Board, List<String>> relatedWordsMap = new HashMap<>();

    int totalWordCount = 0;

    for (board : getBoards()) {
      for (String word : splitWords(board)) {
        // 게시글별 단어 등장 횟수 계산
        int count = wordCountMap.getOrDefault(word, 0);
        wordCountMap.put(word, count + 1);
        totalWordCount++;

        // 전체 단어 중 자주 사용되는 단어 제외
        Set<String> commonWords = getCommonWords(wordCountMap, totalWordCount);
        wordCountMap.keySet().removeAll(commonWords);

        // 게시글 내 단어별 등장 비중 계산
        if (wordCountMap.containsKey(word)) {
          double frequency = (double) wordCountMap.get(word) / totalWordCount;
          wordFrequencyMap.put(word, frequency);
        }

        // 연관 단어 파악
        for (word : wordCountMap.keySet()) {
          if (wordFrequencyMap.containsKey(word)) {
            double frequency = wordFrequencyMap.get(word);
            if (frequency <= WORD_FREQUENCY_THRESHOLD) {
              relatedWords.add(word);
            }
          }
        }
      }
    }

  }
  @Override
  public void sortingRelatedBoard() {
    // Sort related posts by relevance
    Collections.sort(relatedPosts, new Comparator<Post>() {
      public int compare(Post p1, Post p2) {
        int count1 = countCommonWords(p1);
        int count2 = countCommonWords(p2);
        if (count1 != count2) {
          return count2 - count1;
        }
        int freq1 = countUncommonWords(p1);
        int freq2 = countUncommonWords(p2);
        return freq2 - freq1;
      }
    });
  }

  // 게시글별 단어 등장 횟수 계산

  private void findCommonWords() {

  }

  private int countUncommonWords() {
    return 0;
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

  private List<Board> getBoards() {
    return boardRepository.findAll();
  }
}
