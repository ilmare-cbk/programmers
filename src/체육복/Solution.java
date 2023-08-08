package 체육복;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        List<Integer> losts = Arrays.stream(lost).boxed().collect(Collectors.toList());
        List<Integer> reserves = Arrays.stream(reserve).boxed().collect(Collectors.toList());
        for (int i = 1; i <= n; i++) {
            if (!losts.contains(i)) {
                answer++;
            }
            else if (losts.contains(i) && reserves.contains(i)) {
                reserves.remove(Integer.valueOf(i));
                answer++;
            }
            else if (i == 0 && losts.contains(i) && !losts.contains(i + 1) && reserves.contains(i + 1)) {
                reserves.remove(Integer.valueOf(i + 1));
                answer++;
            }
            else if (i == n - 1 && losts.contains(i) && !losts.contains(i - 1) && reserves.contains(i - 1)) {
                reserves.remove(Integer.valueOf(i - 1));
                answer++;
            }
            else if (losts.contains(i) && !losts.contains(i - 1) && reserves.contains(i - 1)) {
                reserves.remove(Integer.valueOf(i - 1));
                answer++;
            }
            else if (losts.contains(i) && !losts.contains(i + 1) && reserves.contains(i + 1)) {
                reserves.remove(Integer.valueOf(i + 1));
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] lost = new int[]{2, 4};
        int[] reserve = new int[]{3};
        Solution solution = new Solution();
        int answer = solution.solution(n, lost, reserve);

        System.out.println(answer);
    }
}
