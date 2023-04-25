package Q2.step1;

public class Solution {
    public int solution(int[] F) {
        int answer = 1;
        int[] sound = new int[9];
        for (int f : F) {
            if (f == 0) {
                answer = 0;
                break;
            }
            sound[f]++;
            if (sound[f] > 1) {
                answer = 0;
                break;
            }
        }
        return answer;
    }
}
