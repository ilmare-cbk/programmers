package 자연수뒤집어배열로만들기;

public class Solution {
    public int[] solution(long n) {
        String[] split = String.valueOf(n).split("");
        int[] answer = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            answer[i] = Integer.parseInt(split[split.length - 1 - i]);
        }
        return answer;
    }
}
