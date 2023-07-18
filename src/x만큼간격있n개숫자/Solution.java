package x만큼간격있n개숫자;

public class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                answer[i] = x;
            } else {
                answer[i] = x + answer[i - 1];
            }
        }
        return answer;
    }
}
