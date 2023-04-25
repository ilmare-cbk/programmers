package Q2.step3;

public class Solution {
    public int solution(int N, int[] F, int[] S, int[] B, int T) {
        if (!enemyExist(B)) {
            return 0;
        }

        int f = distance(F, B);
        int s = distance(S, B);

        if (f - s == 0) {
            return 0;
        }

        int d = f - s > 0 ? 1 : -1;

        int distance = Math.abs(f - s) * 60;
        int gcd = gcd(distance, T);
        int p = distance / gcd;
        int q = T / gcd;

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

    public static void main(String[] args) {
        int N = 20;
        int[] F = new int[]{0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 0, 0, 0, 0, 0, 0, 0};
        int[] S = new int[]{0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 0, 0, 0, 0, 0, 0, 0};
        int[] B = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int T = 777;

        Solution solution = new Solution();
        int answer = solution.solution(N, F, S, B, T);

        System.out.println(answer);
    }
}
