package 제일작은수제거하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] solution(int[] arr) {
        List<Integer> arrList = new ArrayList<>();
        int min = Arrays.stream(arr).min().getAsInt();
        for (int j : arr) {
            if (j != min) {
                arrList.add(j);
            }
        }
        if (arrList.isEmpty()) {
            return new int[]{-1};
        }
        return arrList.stream().mapToInt(it -> it).toArray();
    }
}
