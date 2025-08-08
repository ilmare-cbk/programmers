package P86491;

/**
 * 최소직사각형
 */
public class Solution {
    public int solution(int[][] sizes) {
        int r = 0, c = 0;
        for (int[] size : sizes) {
            r = Math.max(r, Math.max(size[0], size[1]));
            c = Math.max(c, Math.min(size[0], size[1]));
        }
        return r * c;
    }
}
