package P12946;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 하노이의 탑
 */
public class Solution {
    private static List<int[]> path = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(2)));
    }

    public static int[][] solution(int n) {
        hanoi(n, 1, 2, 3);
        return path.toArray(new int[][]{});
    }

    private static void hanoi(int n, int p1, int p2, int p3) {
        if (n == 1) {
            path.add(new int[]{p1, p3});
        } else {
            hanoi(n - 1, p1, p3, p2);
            path.add(new int[]{p1, p3});
            hanoi(n - 1, p2, p1, p3);
        }
    }
}
