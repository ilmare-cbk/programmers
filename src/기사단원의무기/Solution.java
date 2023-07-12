package 기사단원의무기;

public class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;

        int[] commonDivisorCount = new int[number];

        for (int i = 1; i <= number; i++) {
            commonDivisorCount[i - 1] = getCommonDivisorCount(i);
        }

        for (int attackCount : commonDivisorCount) {
            if (attackCount > limit) {
                answer += power;
            } else {
                answer += attackCount;
            }
        }

        return answer;
    }

    private int getCommonDivisorCount(int n) {
        int result = 0;
        for (int i = 1; i * i <= n; i++) {
            if (i * i == n) {
                result++;
            } else if (n % i == 0) {
                result += 2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int number = 10;
        int limit = 3;
        int power = 2;

        Solution solution = new Solution();
        int answer = solution.solution(number, limit, power);

        System.out.println(answer);
    }
}
