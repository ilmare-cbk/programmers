package 콜라문제;

public class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int r = 0;

        while (n / a > 0) {
            r = n % a;
            answer += (n / a) * b;
            n = (n / a) * b + r;
        }

        return answer;
    }

    public static void main(String[] args) {
        int a = 2;
        int b = 1;
        int n = 20;

        Solution solution = new Solution();
        int answer = solution.solution(a, b, n);

        System.out.println(answer);
    }
}
