package Q2447;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 별 찍기 - 10
 */
public class Main {
    private static char[][] stars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        stars = new char[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                stars[i][j] = ' ';
            }
        }
        star(1, 1, N);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sb.append(stars[i][j]);
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private static void star(int r, int c, int n) {
        if (n == 3) {
            stars[r][c] = stars[r][c + 1] = stars[r][c + 2] = '*';
            stars[r + 1][c] = stars[r + 1][c + 2] = '*';
            stars[r + 2][c] = stars[r + 2][c + 1] = stars[r + 2][c + 2] = '*';
        } else {
            int nxt = n / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1 && j == 1) continue;
                    star(r + i * nxt, c + nxt * j, nxt);
                }
            }
        }
    }
}
