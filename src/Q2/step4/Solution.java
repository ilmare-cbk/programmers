package Q2.step4;

public class Solution {
    public int solution(int N, int[] F, int[] S, int[] B, int T, int P, int Q) {
        if (!enemyExist(B)) {
            return 0;
        }

        int f = distance(F, B);
        int s = distance(S, B);

        if (f - s == 0) {
            return 0;
        }

        int d = f - s > 0 ? 1 : -1;

        int numerator = Math.abs(f - s) * 60 * P;
        int denominator = T * Q;
        int gcd = gcd(numerator, denominator);
        int p = numerator / gcd;
        int q = denominator / gcd;

        return d * (p + q);
    }

    private int gcd(int p, int q) {
        while (q != 0) {
            int r = p % q;
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

    private boolean enemyExist(int[] B) {
        int enemy = 1;
        int[] sound = new int[9];
        for (int f : B) {
            if (f == 0) {
                enemy = 0;
                break;
            }
            sound[f]++;
            if (sound[f] > 1) {
                enemy = 0;
                break;
            }
        }
        return enemy == 1;
    }
}
