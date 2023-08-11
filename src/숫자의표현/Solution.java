package 숫자의표현;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i * i <= 2 * n; i++) {
            if ((2 * n) % i == 0) {
                if ((((2 * n) / i ) - i + 1) % 2 == 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
