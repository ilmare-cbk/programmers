package Q1535;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 안녕
 */
//public class Main {
//    private static int[] L;
//    private static int[] J;
//    private static int n;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        n = Integer.parseInt(br.readLine());
//        L = new int[n];
//        J = new int[n];
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++) {
//            L[i] = Integer.parseInt(st.nextToken());
//        }
//
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++) {
//            J[i] = Integer.parseInt(st.nextToken());
//        }
//
//        System.out.println(greet(100, 0));
//    }
//
//    private static int greet(int l, int j) {
//        if (j == n) return 0;
//
//        // 인사를 하지 않는 경우
//        int joy = greet(l, j + 1);
//
//        if (l > L[j]) {
//            joy = Math.max(joy, greet(l - L[j], j + 1) + J[j]);
//        }
//
//        return joy;
//    }
//}

/**
 * 안녕 (백준 1535 - 2차원 DP 버전)
 */
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        int[] L = new int[n];
//        int[] J = new int[n];
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++) {
//            L[i] = Integer.parseInt(st.nextToken());
//        }
//
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++) {
//            J[i] = Integer.parseInt(st.nextToken());
//        }
//
//        int[][] dp = new int[n + 1][101]; // 사람 수 n+1, 체력은 0~100
//
//        for (int i = 1; i <= n; i++) {
//            for (int hp = 0; hp <= 100; hp++) {
//                // 인사 안 함
//                dp[i][hp] = dp[i - 1][hp];
//
//                // 인사 함 (체력이 충분한 경우만)
//                if (hp >= L[i - 1] + 1) {
//                    dp[i][hp] = Math.max(dp[i][hp], dp[i - 1][hp - L[i - 1]] + J[i - 1]);
//                }
//            }
//        }
//
//        int maxJoy = 0;
//        for (int i = 1; i <= 100; i++) {
//            maxJoy = Math.max(maxJoy, dp[n][i]);
//        }
//
//        System.out.println(maxJoy);
//    }
//}

/**
 * 안녕 (백준 1535 - DP 최적화)
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] L = new int[n];  // 체력 소모
        int[] J = new int[n];  // 기쁨

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            J[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[101]; // 체력 1~100까지, 0은 죽음 상태

        for (int i = 0; i < n; i++) {
            // 역순으로 순회해서 덮어쓰기 방지 (0-1 Knapsack 패턴)
            for (int hp = 100; hp >= L[i] + 1; hp--) {
                dp[hp] = Math.max(dp[hp], dp[hp - L[i]] + J[i]);
            }
        }

        int maxJoy = 0;
        for (int i = 1; i <= 100; i++) {
            maxJoy = Math.max(maxJoy, dp[i]);
        }

        System.out.println(maxJoy);
    }
}

