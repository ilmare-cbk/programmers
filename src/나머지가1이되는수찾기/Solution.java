package 나머지가1이되는수찾기;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i * i <= n - 1; i++) {
            if ((n - 1) % i == 0) {
                answer = i == 1 ? (n - 1) / i : Math.min(i, answer);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 12;
        Solution solution = new Solution();
        int answer = solution.solution(n);

        System.out.println(answer);
    }
}
