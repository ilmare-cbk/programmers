package Q16174;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 점프왕 쩰리 (Large)
 */
public class Main {
    private static int N;
    private static String answer = "Hing";
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(1, 1);
        System.out.println(answer);
    }

    private static void dfs(int i, int j) {
        visited[i][j] = true;
        if (i == N && j == N) {
            answer = "HaruHaru";
            return;
        }

        int jump = map[i][j];
        if (i + jump <= N && !visited[i + jump][j]) {
            dfs(i + jump, j);
        }
        if (j + jump <= N && !visited[i][j + jump]) {
            dfs(i, j + jump);
        }
    }
}
