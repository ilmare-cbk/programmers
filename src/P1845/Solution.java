package P1845;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 포켓몬
 */
public class Solution {
    public int solution(int[] nums) {
        int N = nums.length;
        Set<Integer> pocketmons = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());
        return Math.min(N / 2, pocketmons.size());
    }
}
