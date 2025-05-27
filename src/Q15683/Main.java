package Q15683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 감시
 */
public class Main {
    private static int N, M;
    private static int[][] map;
    private static List<int[]> cctvs = new ArrayList<>();
    private static int answer = Integer.MAX_VALUE;
    private static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
                if (n >= 1 && n <= 5) {
                    cctvs.add(new int[]{n, i, j, 10 * i + j});
                }
            }
        }
        recursionMonitor(0);
        System.out.println(answer);
    }

    private static void recursionMonitor(int cctvIdx) {
        if (cctvIdx == cctvs.size()) {
            int temp = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (map[i][j] == 0) temp++;
                }
            }
            answer = Math.min(answer, temp);
            return;
        }

        int[] cctv = cctvs.get(cctvIdx);
        int cctvNum = cctv[0], r = cctv[1], c = cctv[2], checkNum = cctv[3];
        switch (cctvNum) {
            case 1:
                for (int[] d : direction) {
                    check(r, c, d, checkNum);
                    recursionMonitor(cctvIdx + 1);
                    rollback(r, c, d, checkNum);
                }
                break;
            case 2:
                for (int i = 0; i < 2; i++) {
                    check(r, c, direction[i], checkNum);
                    check(r, c, direction[i + 2], checkNum);
                    recursionMonitor(cctvIdx + 1);
                    rollback(r, c, direction[i], checkNum);
                    rollback(r, c, direction[i + 2], checkNum);
                }
                break;
            case 3:
                for (int i = 0; i < 4; i++) {
                    check(r, c, direction[i % 4], checkNum);
                    check(r, c, direction[(i + 1) % 4], checkNum);
                    recursionMonitor(cctvIdx + 1);
                    rollback(r, c, direction[i % 4], checkNum);
                    rollback(r, c, direction[(i + 1) % 4], checkNum);
                }
                break;
            case 4:
                for (int i = 0; i < 4; i++) {
                    check(r, c, direction[i % 4], checkNum);
                    check(r, c, direction[(i + 1) % 4], checkNum);
                    check(r, c, direction[(i + 2) % 4], checkNum);
                    recursionMonitor(cctvIdx + 1);
                    rollback(r, c, direction[i % 4], checkNum);
                    rollback(r, c, direction[(i + 1) % 4], checkNum);
                    rollback(r, c, direction[(i + 2) % 4], checkNum);
                }
                break;
            case 5:
                for (int i = 0; i < 4; i++) {
                    check(r, c, direction[i], checkNum);
                }
                recursionMonitor(cctvIdx + 1);
                for (int i = 0; i < 4; i++) {
                    rollback(r, c, direction[i], checkNum);
                }
                break;
        }

    }

    private static void rollback(int r, int c, int[] d, int checkNum) {
        int dr = r + d[0], dc = c + d[1];
        while (isValid(dr, dc) && map[dr][dc] != 6) {
            if (map[dr][dc] == checkNum) {
                map[dr][dc] = 0;//해당 cctv로 감시한 영역 롤백
            }
            dr += d[0];
            dc += d[1];
        }
    }

    private static void check(int r, int c, int[] d, int checkNum) {
        int dr = r + d[0], dc = c + d[1];
        while (isValid(dr, dc) && map[dr][dc] != 6) {
            if (map[dr][dc] == 0) {
                map[dr][dc] = checkNum;
            }
            dr += d[0];
            dc += d[1];
        }
    }

    private static boolean isValid(int r, int c) {
        return r > 0 && r <= N && c > 0 && c <= M;
    }
}
