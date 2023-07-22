package 두정수사이의합;

public class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int count = Math.max(a, b) - Math.min(a, b) + 1;
        if (count % 2 == 0) {
            answer = (long) (a + b) * (count / 2);
        } else {
            answer = (long) (a + b) * ((count - 1) / 2) + (a + b) / 2;
        }
        return answer;
    }
}
