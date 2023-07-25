package 최솟값만들기;

import java.util.Arrays;

public class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[A.length - 1 - i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 4, 2};
        int[] B = new int[]{5, 4, 4};
        Solution solution = new Solution();
        int answer = solution.solution(A, B);
        System.out.println(answer);
    }
}
