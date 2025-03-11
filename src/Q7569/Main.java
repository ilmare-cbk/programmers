package Q7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 토마토
 */
public class Main {
    private static int M;
    private static int N;
    private static int H;
    private static int[][][] box;
    private static Queue<Tomato> queue = new LinkedList<>();
    private static int dm[] = {-1, 1, 0, 0, 0, 0};
    private static int dn[] = {0, 0, -1, 1, 0, 0};
    private static int dh[] = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]); // 가로
        N = Integer.parseInt(input[1]); // 세로
        H = Integer.parseInt(input[2]); // 높이
        box = new int[H][N][M];

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                String[] tomatoes = br.readLine().split(" ");
                for (int m = 0; m < M; m++) {
                    int status = Integer.parseInt(tomatoes[m]);
                    box[h][n][m] = status;
                    if (status == 1) { // 익은 토마토
                        queue.add(new Tomato(h, n, m));
                    }
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        int days = 1;
        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            int h = tomato.getH();
            int n = tomato.getN();
            int m = tomato.getM();

            for (int i = 0; i < 6; i++) {
                int moveH = h + dh[i];
                int moveN = n + dn[i];
                int moveM = m + dm[i];
                if (movable(moveH, moveN, moveM)) {
                    queue.add(new Tomato(moveH, moveN, moveM));
                    box[moveH][moveN][moveM] = box[h][n][m] + 1;
                    days = Math.max(days, box[moveH][moveN][moveM]);
                }
            }
        }

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (box[h][n][m] == 0) {
                        return -1;
                    }
                }
            }
        }

        return days - 1;
    }

    private static boolean movable(int h, int n, int m) {
        if (h < 0 || h >= H || n < 0 || n >= N || m < 0 || m >= M) {
            return false;
        }
        return box[h][n][m] == 0;
    }

    private static class Tomato {
        private final int h;
        private final int n;
        private final int m;

        public Tomato(int h, int n, int m) {
            this.h = h;
            this.n = n;
            this.m = m;
        }

        public int getM() {
            return m;
        }

        public int getN() {
            return n;
        }

        public int getH() {
            return h;
        }
    }
}
/*
5 5 2
1 0 1 -1 1
0 1 0 1 0
1 0 1 0 1
0 1 0 1 0
1 0 1 0 -1
-1 -1 0 0 0
0 0 0 0 0
1 1 1 1 1
0 0 0 0 0
1 1 1 1 1

5 5 1
1 0 1 -1 1
0 1 0 1 0
1 0 1 0 1
0 1 0 1 0
1 0 1 0 -1

5 5 1
-1 -1 0 0 0
0 0 0 0 0
1 1 1 1 1
0 0 0 0 0
1 1 1 1 1

5 1 1
1 0 1 0 1

1 5 1
1
0
1
0
1

1 5 1
0
1
0
1
0

2 5 1
1 1
0 0
1 1
0 0
1 1
 */