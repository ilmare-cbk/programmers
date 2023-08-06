package 점프와순간이동;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        while (n != 0) {
            if (n % 2 != 0) {
                answer++;
                n = n - 1;
            }
            n = n / 2;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        Solution solution = new Solution();
        int answer = solution.solution(n);

        System.out.println(answer);
    }
}
