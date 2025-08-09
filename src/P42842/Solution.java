package P42842;

/**
 * 카펫
 */
public class Solution {

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int b = (-1) * ((brown / 2) + 2); // 두 수의 합
        int c = brown + yellow; // 두 수의 곱
        answer[0] = (int) (((-1 * b) + Math.sqrt(b * b - 4 * c)) / 2);
        answer[1] = (int) (((-1 * b) - Math.sqrt(b * b - 4 * c)) / 2);
        return answer;
    }
}
