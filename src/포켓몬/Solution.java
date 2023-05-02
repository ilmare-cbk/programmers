package 포켓몬;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(int[] nums) {
        int select = nums.length / 2;
        Map<Integer, Boolean> selectPocketmonCountMap = new HashMap<>();
        for (int num : nums) {
            boolean catchedPocketmon = selectPocketmonCountMap.getOrDefault(num, false);
            if (!catchedPocketmon && select > 0) {
                select--;
                selectPocketmonCountMap.put(num, true);
            }
        }
        return selectPocketmonCountMap.keySet().size();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 3, 2, 2, 4};
        Solution solution = new Solution();
        int answer = solution.solution(nums);

        System.out.println(answer);
    }
}
