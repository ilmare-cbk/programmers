package 정수내림차순으로배치하기;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public long solution(long n) {
        long answer = 0;
        String[] split = String.valueOf(n).split("");
        Arrays.sort(split, Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            sb.append(s);
        }
        answer = Long.parseLong(sb.toString());
        return answer;
    }
}
