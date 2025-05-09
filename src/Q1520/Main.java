package Q1520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 내리막 길
 */
public class Main {
    private static int[][] map;
    private static int[][] dp;
    private static int M, N;
    private static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M + 1][N + 1];
        dp = new int[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(1, 1));
    }

    private static int dfs(int i, int j) {
        if (i == M && j == N) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        dp[i][j] = 0;
        for (int[] m : move) {
            int dx = i + m[0];
            int dy = j + m[1];
            if (dx > 0 && dx <= M && dy > 0 && dy <= N && map[dx][dy] < map[i][j]) {
                dp[i][j] += dfs(dx, dy);
            }
        }

        return dp[i][j];
    }
}
