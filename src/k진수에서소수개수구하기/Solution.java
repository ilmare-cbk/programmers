package k진수에서소수개수구하기;

import java.util.Arrays;

/**
 * 1. K진법으로 변환
 * 2. 0을 기준으로 split
 * 3. split한 값이 소수인지 판단
 */
public class Solution {
    public int solution(int n, int k) {
        int answer = -1;

        // K진법 변환
        String convertedNumber = Integer.toString(n, k);
        answer = (int) Arrays.stream(convertedNumber.split("0"))
                .filter(it -> !it.isEmpty())
                .map(Long::parseLong)
                .filter(this::isPrime)
                .count();

        return answer;
    }

    private boolean isPrime(long n) {
        if (n == 1) {
            return false;
        }

        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 437674;
        int k = 3;

        Solution solution = new Solution();
        int answer = solution.solution(n, k);

        System.out.println(answer);
    }
}
