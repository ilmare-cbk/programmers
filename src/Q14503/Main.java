package Q14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 로봇 청소기
 */
public class Main {
    private static int cnt = 0;
    private static int[][] map;
    private static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static boolean stop = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        move(r, c, d);
        System.out.println(cnt);
    }

    private static void move(int r, int c, int d) {
        if (stop) return;

        if (map[r][c] == 0) {
            cnt++;
            map[r][c] = -1;
        }

        boolean clean = true;
        for (int[] m : directions) {
            int dr = r + m[0];
            int dc = c + m[1];
            if (map[dr][dc] == 0) {
                clean = false;
                break;
            }
        }

        // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
        if (clean) {
            int[] m = directions[(d + 2) % 4];
            int dr = r + m[0];
            int dc = c + m[1];
            if (map[dr][dc] != 1) {
                move(dr, dc, d);
            } else {
                stop = true;
            }
        }
        // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
        else {
            int direction = d;
            int dr = 0, dc = 0;
            boolean flag = false;
            for (int i = 1; i <= 4; i++) {
                direction = (direction + 3) % 4;
                int[] m = directions[direction];
                dr = r + m[0];
                dc = c + m[1];
                if (map[dr][dc] == 0) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                move(dr, dc, direction);
            }
        }
    }
}
