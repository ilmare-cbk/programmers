package Q10997;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 별 찍기 - 22
 */
public class Main {
    private static char[][] stars;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int c = 4 * (N - 1) + 1;
        int r = c + 2;

        if (N == 1) {
            System.out.println("*");
            return;
        }

        stars = new char[r + 1][c + 1];

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                stars[i][j] = ' ';
            }
        }
        star((r + 1) / 2, (c + 1) / 2, r, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (i == 2 && j != 1) continue;
                sb.append(stars[i][j]);
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private static void star(int r, int c, int h, int n) {
        if (n == 1) {
            stars[r][c] = '*';
        } else {
            if (n == N) {
                stars[r + 1][c] = stars[r - 1][c] = '*';
            }
            for (int j = 1; j <= h - 2; j++) {
                stars[r - (h + 1) / 2 + 1][c - (h - 1) / 2 + j] = '*';
                stars[r + (h + 1) / 2 - 1][c - (h - 1) / 2 + j] = '*';
            }
            for (int i = 2; i <= h - 1; i++) {
                stars[r - (h + 1) / 2 + i][c - (h - 1) / 2 + 1] = '*';
                if (i != 2) {
                    stars[r - (h + 1) / 2 + i][c - (h - 1) / 2 + 1] = '*';
                    stars[r - (h + 1) / 2 + i][c + (h - 1) / 2 - 1] = '*';
                }
            }
            star(r, c, h - 4, n - 1);
            stars[r - (h + 1) / 2 + 3][c + (h - 1) / 2 - 2] = '*';
        }
    }
}
