package Q2.step5;

public class Solution {
    private static final int MOD = 1_000_000_009;

    public int solution(int N, int[] F, int[] S, int[] B, int T, int P, int Q, int W, int O) {
        int f = distance(F, B);
        int s = distance(S, B);
        long denominator = (((long) W * Q * T) - (60L * P * (s - f) * O));
        long numerator = (long) s * P * T * O;
        if (denominator > 0 && numerator >= 0) {
            long gcd = gcd(denominator, numerator);
            long p = numerator / gcd;
            long q = denominator / gcd;
            return (int) ((p + q) % MOD);
        }

        return -1;
    }

    private long gcd(long p, long q) {
        while (q != 0) {
            long r = p % q;
            p = q;
            q = r;
        }
        return p;
    }

    private int distance(int[] F, int[] B) {
        int distance = 0;
        for (int i = 0; i < F.length; i++) {
            if (F[i] != B[0]) {
                continue;
            }
            if (identical(F, B, i)) {
                distance = i + 1;
                break;
            }
        }
        return distance;
    }

    private boolean identical(int[] F, int[] B, int index) {
        if (F.length - index < B.length) {
            return false;
        }

        for (int i = 0; i < B.length; i++) {
            if (F[index + i] != B[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int N = 9;
        int[] F = new int[]{0,1,2,3,4,5,6,7,8};
        int[] S = new int[]{1, 2, 3, 4, 5, 6, 7, 8,0};
        int[] B = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int T = 7;
        int P = 28;
        int Q = 4;
        int W = 0;
        int O = 1234;

        Solution solution = new Solution();
        int answer = solution.solution(N, F, S, B, T, P, Q, W, O);
        int distance = solution.distance(F, B);
        System.out.println(distance);
        System.out.println(answer);
        long a = 100L * 10000 * 1000 * 10000;
        int b = 100 * 10000 * 1000;
        System.out.println(a);
        System.out.println(b);
    }
}
