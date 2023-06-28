package 주식가격;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            int up = 0;
            for (int j = i + 1; j < prices.length; j++) {
                up++;
                if (price > prices[j]) {
                    break;
                }
            }
            answer[i] = up;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{5, 4, 3, 2, 5};

        Solution solution = new Solution();
        int[] answers = solution.solution(prices);

        System.out.println(Arrays.toString(Arrays.stream(answers).toArray()));
    }
}
