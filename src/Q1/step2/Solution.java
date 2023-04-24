package Q1.step2;

public class Solution {
    public int solution(int H, int W, int[] D) {
        int answer = 0;
        for (int i = 0; i < D.length; i++) {
            int lanLength = D[i];
            if (lanLength >= H) {
                answer++;
                continue;
            }
            if (i != 0 && lanLength + D[i - 1] - H >= H) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int H = 5;
        int W = 4;
        int[] D = new int[]{6,8,5};
        Solution solution = new Solution();
        int answer = solution.solution(H, W, D);
        System.out.println(answer);
    }
}
