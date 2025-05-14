package Q10993;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 별 찍기 - 18
 */
public class Main {
    private static char[][] stars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int size = 1;
        for (int i = 2; i <= N; i++) {
            size = 2 * size + 1;
        }
        stars = new char[size + 1][2 * size];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j < 2 * size; j++) {
                stars[i][j] = ' ';
            }
        }

        StringBuilder sb = new StringBuilder();
        if (N % 2 == 0) {
            star(size, size, size, N);
            for (int i = 1; i <= size; i++) {
                for (int j = 1; j <= 2 * size - i; j++) {
                    sb.append(stars[i][j]);
                }
                sb.append(System.lineSeparator());
            }
            System.out.println(sb);
        } else {
            star(1, size, size, N);
            for (int i = 1; i <= size; i++) {
                for (int j = 1; j < size + i; j++) {
                    sb.append(stars[i][j]);
                }
                sb.append(System.lineSeparator());
            }
            System.out.println(sb);
        }
    }

    private static void star(int r, int c, int h, int n) {
        if (n == 1) {
            stars[r][c] = '*';
        } else {
            if (n % 2 == 0) {
                for (int i = 1; i <= h; i++) {
                    if (i == 1) {
                        for (int j = 1; j <= 2 * h - 1; j++) {
                            stars[r - h + i][c - h + j] = '*';
                        }
                    }
                    stars[r - h + i][c - h + i] = '*';
                    stars[r - h + i][c + h - i] = '*';
                }
                star(r - h + 2, c, (h - 1) / 2, n - 1);
            } else {
                for (int i = 1; i <= h; i++) {
                    if (i == h) {
                        for (int j = 1; j <= 2 * h - 1; j++) {
                            stars[r + h - 1][c - h + j] = '*';
                        }
                    }
                    stars[r + i - 1][c - i + 1] = '*';
                    stars[r + i - 1][c + i - 1] = '*';
                }
                star(r + h - 2, c, (h - 1) / 2, n - 1);
            }
        }
    }
}
