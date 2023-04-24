package Q1.step1;

public class Solution {
    public int solution(int H, int W, int[] D) {
        int answer = 0;
        for (int lanLength : D) {
            if (lanLength >= H) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int H = 5;
        int W = 4;
        int[] D = new int[]{1000,1000,1000};
        Solution solution = new Solution();
        int answer = solution.solution(H, W, D);
        System.out.println(answer);
    }
}
