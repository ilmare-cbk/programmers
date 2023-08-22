package 할인행사;

import java.util.Arrays;

public class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int totalCount = Arrays.stream(number).sum();

        int i;
        for (i = 0; i <= discount.length - totalCount; i++) {
            int j;
            for (j = 0; j < want.length; j++) {
                int match = 0;
                for (int k = i; k < totalCount + i; k++) {
                    if (discount[k].equals(want[j])) {
                        match++;
                    }
                }
                if (match != number[j]) {
                    break;
                }
            }
            if (j == want.length) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] want = new String[]{"banana", "apple", "rice", "pork", "pot"};
        int[] number = new int[]{3, 2, 2, 2, 1};
        String[] discount = new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        Solution solution = new Solution();
        int answer = solution.solution(want, number, discount);

        System.out.println(answer);
    }
}
