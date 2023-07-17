package 자릿수더하기;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String[] s = String.valueOf(n).split("");
        for (String value : s) {
            answer += Integer.parseInt(value);
        }
        return answer;
    }
}
