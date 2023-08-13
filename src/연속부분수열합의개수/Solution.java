package 연속부분수열합의개수;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int solution(int[] elements) {
        Set<Integer> answer = new HashSet<>();
        for (int i = 0; i < elements.length; i++) { // 연속된 갯수
            for (int j = 0; j < elements.length; j++) { // 묶음의 시작 위치
                int sum = 0;
                for (int k = j; k <= j + i; k++) {
                    if (k >= elements.length) {
                        sum += elements[k - elements.length];
                    }
                    else {
                        sum += elements[k];
                    }
                }
                answer.add(sum);
            }
        }
        return answer.size();
    }

    public static void main(String[] args) {
        int[] elements = new int[]{7,9,1,1,4};

        Solution solution = new Solution();
        int answer = solution.solution(elements);

        System.out.println(answer);
    }
}
