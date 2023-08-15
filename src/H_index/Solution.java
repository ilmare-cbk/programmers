package H_index;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Integer[] integerArray = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(integerArray, Collections.reverseOrder());
        for (int i = 1; i <= integerArray.length; i++) {
            if (integerArray[i - 1] >= i) {
                answer = i;
            } else {
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] citations = new int[]{3, 0, 6, 1, 5};
        Solution solution = new Solution();
        int answer = solution.solution(citations);

        System.out.println(answer);
    }
}
