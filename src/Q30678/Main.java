package Q30678;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 별 안에 별 안에 별 찍기
 */
public class Main {
    private static char[][] stars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 0) {
            System.out.println("*");
            return;
        }
        int size = (int) Math.pow(5, N);
        stars = new char[size + 1][size + 1];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                stars[i][j] = ' ';
            }
        }

        star(1, (size + 1) / 2, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                sb.append(stars[i][j]);
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private static void star(int r, int c, int n) {
        if (n == 1) {
            stars[r][c] = '*';
            stars[r + 1][c] = '*';
            stars[r + 2][c - 2] = stars[r + 2][c - 1] = stars[r + 2][c] = stars[r + 2][c + 1] = stars[r + 2][c + 2] = '*';
            stars[r + 3][c] = stars[r + 3][c - 1] = stars[r + 3][c + 1] = '*';
            stars[r + 4][c - 1] = stars[r + 4][c + 1] = '*';
        } else {
            int pow = (int) Math.pow(5, n - 1);
            star(r, c, n - 1);
            star(r + pow, c, n - 1);
            star(r + 2 * pow, c - 2 * pow, n - 1);
            star(r + 2 * pow, c - pow, n - 1);
            star(r + 2 * pow, c, n - 1);
            star(r + 2 * pow, c + pow, n - 1);
            star(r + 2 * pow, c + 2 * pow, n - 1);
            star(r + 3 * pow, c, n - 1);
            star(r + 3 * pow, c - pow, n - 1);
            star(r + 3 * pow, c + pow, n - 1);
            star(r + 4 * pow, c - pow, n - 1);
            star(r + 4 * pow, c + pow, n - 1);
        }
    }
}
