package P12977;

/**
 * 소수 만들기
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4}));
    }

    public static int solution(int[] nums) {
        int answer = 0;
        boolean[] nonPrime = new boolean[50000];
        nonPrime[0] = nonPrime[1] = true;
        for (int i = 2; i < nonPrime.length; i++) {
            if (nonPrime[i]) {
                continue;
            }

            for (int j = 2; j * i < nonPrime.length; j++) {
                nonPrime[j * i] = true;
            }
        }

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (!nonPrime[nums[i] + nums[j] + nums[k]]) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}
