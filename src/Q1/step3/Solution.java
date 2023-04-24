package Q1.step3;

public class Solution {
    public int solution(int H, int W, int[] D) {
        int answer = 0;
        int addedLangLength = 0;
        for (int i = 0; i < D.length; i++) {
            int lanLength = D[i];
            if (lanLength >= H) {
                answer++;
                addedLangLength = Math.max(addedLangLength, lanLength - H);
                continue;
            }
            if (lanLength + addedLangLength >= H) {
                answer++;
                addedLangLength = 0;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int H = 5;
        int W = 6;
        int D[] = new int[]{7,9,2,1,4};
        Solution solution = new Solution();
        int answer = solution.solution(H, W, D);
        System.out.println(answer);

    }
}
