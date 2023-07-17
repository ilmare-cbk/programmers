package 짝수와홀수;

public class Solution {
    public String solution(int num) {
        String answer = "Odd";
        if (num % 2 == 0) {
            answer = "Even";
        }
        return answer;
    }
}
