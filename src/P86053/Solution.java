package P86053;

/**
 * 금과 은 운반하기
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(
                solution(10, 10, new int[]{100}, new int[]{100}, new int[]{7}, new int[]{10})
        );
    }

    public static long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long low = 0L, high = 400000000000000L;
        while (low < high) {
            long mid = (low + high) / 2;

            if (isPossible(mid, a, b, g, s, w, t)) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    private static boolean isPossible(long time, int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long total = 0L, totalG = 0L, totalS = 0L;
        int n = g.length;

        for (int i = 0; i < n; i++) {
            long cnt = time / t[i];
            cnt -= (cnt / 2);

            long weightInTime = Math.min(g[i] + s[i], w[i] * cnt);
            total += weightInTime;
            totalG += Math.min(g[i], weightInTime);
            totalS += Math.min(s[i], weightInTime);
        }

        return total >= a + b && totalG >= a && totalS >= b;
    }
}
