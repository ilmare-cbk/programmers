package P42839;

import java.util.HashSet;
import java.util.Set;

/**
 * 소수 찾기
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("011"));
    }

    public int solution(String numbers) {
        int answer = 0;
        boolean[] nonPrime = new boolean[10000000];
        nonPrime[0] = nonPrime[1] = true; // 0, 1 소수 아님

        for (int i = 2; i < 10000000; i++) {
            if (nonPrime[i]) continue;

            for (int j = 2; j * i < 10000000; j++) {
                nonPrime[j * i] = true;
            }
        }

        String[] digits = numbers.split("");
        Set<Integer> nums = new HashSet<>();
        for (int i = 0; i < digits.length; i++) {
            boolean[] visited = new boolean[digits.length];
            dfs(nums, visited, digits, "");
        }

        for (Integer num : nums) {
            if (!nonPrime[num]) answer++;
        }

        return answer;
    }

    private void dfs(Set<Integer> nums, boolean[] visited, String[] digits, String cur) {
        if (cur.length() == visited.length) {
            return;
        }

        for (int i = 0; i < digits.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            String number = cur.concat(digits[i]);
            nums.add(Integer.valueOf(number));
            dfs(nums, visited, digits, number);
            visited[i] = false;
        }

    }

}
