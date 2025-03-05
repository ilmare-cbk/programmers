package Q2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 미로 탐색
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        int[][] count = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split("");
            for (int j = 0; j < data.length; j++) {
                count[i][j] = Integer.MAX_VALUE; // 초기화
                map[i][j] = Integer.parseInt(data[j]);
            }
        }

        int i = 0;
        int j = 0;
        visited[i][j] = true;
        count[i][j] = 1;
        move(i, map, j, visited, count, N, M);

        System.out.println(count[N - 1][M - 1]);
    }

    private static void move(int i, int[][] map, int j, boolean[][] visited, int[][] count, int N, int M) {
        // 상
        int c = count[i][j] + 1;
        if (i - 1 >= 0 && map[i - 1][j] != 0) {
            if (count[i - 1][j] > c) {
                visited[i - 1][j] = true;
                count[i - 1][j] = c;
                move(i - 1, map, j, visited, count, N, M);
            }
        }
        // 하
        if (i + 1 < N && map[i + 1][j] != 0) {
            if (count[i + 1][j] > c) {
                visited[i + 1][j] = true;
                count[i + 1][j] = c;
                move(i + 1, map, j, visited, count, N, M);
            }
        }
        // 좌
        if (j - 1 >= 0 && map[i][j - 1] != 0) {
            if (count[i][j - 1] > c) {
                visited[i][j - 1] = true;
                count[i][j - 1] = c;
                move(i, map, j - 1, visited, count, N, M);
            }
        }
        // 우
        if (j + 1 < M && map[i][j + 1] != 0) {
            if (count[i][j + 1] > c) {
                visited[i][j + 1] = true;
                count[i][j + 1] = c;
                move(i, map, j + 1, visited, count, N, M);
            }
        }
    }
}
