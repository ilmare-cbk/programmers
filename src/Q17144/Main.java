package Q17144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 미세먼지 안녕!
 */
public class Main {
    private static int R;
    private static int C;
    private static int T;
    private static int[][] map;
    private static int[][] increase;
    private static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int air_r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        increase = new int[R][C];
        for (int i = 0; i < R; i++) {
            StringTokenizer data = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int a = Integer.parseInt(data.nextToken());
                map[i][j] = a;
                if (a == -1) {
                    air_r = i;
                }
            }
        }
        while (T-- > 0) {
            for (int r = 0; r < R; r++) {
                Arrays.fill(increase[r], 0);
            }
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    int a = map[r][c];
                    if (a == 0 || a == -1) {
                        continue;
                    }
                    int da = a / 5;
                    for (int[] ints : move) {
                        int dr = r + ints[0];
                        int dc = c + ints[1];
                        if (dr >= 0 && dr < R && dc >= 0 && dc < C && map[dr][dc] != -1) {
                            map[r][c] -= da;
                            increase[dr][dc] += da;
                        }
                    }
                }
            }
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    map[r][c] += increase[r][c];
                }
            }

            upAir(air_r - 1, 1);
            downAir(air_r, 1);
        }
        int answer = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                int a = map[r][c];
                if (a != -1 && a != 0) {
                    answer += a;
                }
            }
        }
        System.out.println(answer);
    }

    private static void upAir(int r, int c) {
        int next;
        int prev = 0;
        while (map[r][c] != -1) {
            next = map[r][c];
            map[r][c] = prev;
            prev = next;

            if (r == air_r - 1 && c != C - 1) {
                c++;
                continue;
            }
            if (c == C - 1 && (r != 0 || r == air_r - 1)) {
                r--;
                continue;
            }
            if (r == 0 && (c == C - 1 || c != 0)) {
                c--;
                continue;
            }
            if (c == 0 && (r == 0 || r != air_r - 1)) {
                r++;
            }
        }
    }

    private static void downAir(int r, int c) {
        int next;
        int prev = 0;
        while (map[r][c] != -1) {
            next = map[r][c];
            map[r][c] = prev;
            prev = next;

            if (r == air_r && c != C - 1) {
                c++;
                continue;
            }
            if (c == C - 1 && (r != R - 1 || r == air_r)) {
                r++;
                continue;
            }
            if (r == R - 1 && (c == C - 1 || c != 0)) {
                c--;
                continue;
            }
            if (c == 0 && (r == R - 1 || r != air_r)) {
                r--;
            }
        }
    }
}
