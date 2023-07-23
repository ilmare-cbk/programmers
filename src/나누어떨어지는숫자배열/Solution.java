package 나누어떨어지는숫자배열;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(arr);
        for (int j : arr) {
            if (j % divisor == 0) {
                answer.add(j);
            }
        }

        if (answer.isEmpty()) {
            answer.add(-1);
        }

        return answer.stream().mapToInt(it -> it).toArray();
    }
}
