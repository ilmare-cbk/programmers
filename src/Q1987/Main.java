package Q1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 알파벳
 */
public class Main {
    private static int R;
    private static int C;
    private static char[][] map;
    private static boolean[] visited = new boolean[26];
    private static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        map = new char[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            String[] data = br.readLine().split("");
            for (int j = 1; j <= C; j++) {
                map[i][j] = data[j - 1].charAt(0);
            }
        }
        visited[map[1][1] - 65] = true;
        search(1, 1, 1);
        System.out.println(answer);
    }

    private static void search(int r, int c, int move) {
        if (r - 1 >= 1 && !visited[map[r - 1][c] - 65]) {
            visited[map[r - 1][c] - 65] = true;
            search(r - 1, c, move + 1);
            visited[map[r - 1][c] - 65] = false;
        }
        if (r + 1 <= R && !visited[map[r + 1][c] - 65]) {
            visited[map[r + 1][c] - 65] = true;
            search(r + 1, c, move + 1);
            visited[map[r + 1][c] - 65] = false;
        }
        if (c - 1 >= 1 && !visited[map[r][c - 1] - 65]) {
            visited[map[r][c - 1] - 65] = true;
            search(r, c - 1, move + 1);
            visited[map[r][c - 1] - 65] = false;
        }
        if (c + 1 <= C && !visited[map[r][c + 1] - 65]) {
            visited[map[r][c + 1] - 65] = true;
            search(r, c + 1, move + 1);
            visited[map[r][c + 1] - 65] = false;
        }

        answer = Math.max(answer, move);
    }
}
