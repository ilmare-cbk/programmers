package 체스판다시칠하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int MIN = 64;
    private static boolean[][] chess;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] MN = br.readLine().split(" ");
        int M = Integer.parseInt(MN[0]);
        int N = Integer.parseInt(MN[1]);
        chess = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                chess[i][j] = str.charAt(j) == 'W';
            }
        }

        for (int i = 0; i <= M - 8; i++) {
            for (int j = 0; j <= N - 8; j++) {
                find(i, j);
            }
        }

        System.out.println(MIN);
    }

    private static void find(int x, int y) {
        boolean color = chess[x][y];
        int count = 0;
        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (chess[i][j] != color) {
                    count++;
                }
                color = !color;
            }
            color = !color;
        }
        count = Math.min(count, 64 - count);
        MIN = Math.min(MIN, count);
    }
}
