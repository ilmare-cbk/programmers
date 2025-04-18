package Q24418;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 알고리즘 수업 - 행렬 경로 문제 1
 */
public class Main {
    private static int n;
    private static int[][] m;
    private static int[][] dp;
    private static int c1 = 0, c2 = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = new int[n + 1][n + 1];
        dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                m[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        matrix_path1();
        matrix_path2();

        System.out.println(c1 + " " + c2);
    }

    private static int matrix_path1() {
        return matrix_path_rec(n, n);
    }

    private static int matrix_path_rec(int i, int j) {
        if (i == 0 || j == 0) {
            c1++;
            return 0;
        } else return m[i][j] + Math.max(matrix_path_rec(i - 1, j), matrix_path_rec(i, j - 1));
    }

    private static int matrix_path2() {
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                c2++;
                dp[i][j] = m[i][j] + Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][n];
    }
}
