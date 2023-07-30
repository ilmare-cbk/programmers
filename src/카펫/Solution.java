package 카펫;

import java.util.Arrays;

public class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0, 0};
        int height = 0;
        int weight = 0;
        int area = brown + yellow; // = height * weight

        for (int i = 1; i * i <= area; i++) {
            if ((area) % i == 0) {
                weight = Math.max(i, area / i);
                height = Math.min(i, area / i);
                if ((brown / 2) + 2 == weight + height) {
                    answer[0] = weight;
                    answer[1] = height;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int brown = 10;
        int yellow = 2;
        Solution solution = new Solution();
        int[] answer = solution.solution(brown, yellow);
        System.out.println(Arrays.toString(Arrays.stream(answer).toArray()));
    }
}
