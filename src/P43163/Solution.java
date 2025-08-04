package P43163;

import java.util.*;

/**
 * 단어 변환
 */
public class Solution {

    public int solution(String begin, String target, String[] words) {
        List<Word> wordList = new ArrayList<>();
        for (String word : words) {
            wordList.add(new Word(word, 50));
        }
        Queue<Word> queue = new LinkedList<>();
        queue.add(new Word(begin, 0));

        while (!queue.isEmpty()) {
            Word word = queue.poll();

            if (word.w.equals(target)) {
                return word.step;
            }

            for (Word s : wordList) {
                if (!word.isConvertible(s)) continue;
                if (word.step + 1 < s.step) {
                    s.step = word.step + 1;
                    queue.add(s);
                }
            }
        }

        return 0;
    }

    private static class Word {
        String w;
        int step;

        public boolean isConvertible(Word begin) {
            int nonMatch = 0;
            for (int i = 0; i < w.length(); i++) {
                if (w.charAt(i) != begin.w.charAt(i)) {
                    nonMatch++;
                }
                if (nonMatch > 1) {
                    return false;
                }
            }
            return true;
        }

        public Word(String w, int step) {
            this.w = w;
            this.step = step;
        }
    }
}
