package 약수의합;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i * i < n; i++) {
            if (n % i == 0) {
                answer += i;
                if (i * i != n) {
                    answer += n / i;
                }
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
