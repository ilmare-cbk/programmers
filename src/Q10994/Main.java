package Q10994;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 별 찍기 - 19
 */
public class Main {
    private static char[][] stars;
    private static int r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int size = 4 * (N - 1) + 1;
        stars = new char[size + 1][size + 1];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                stars[i][j] = ' ';
            }
        }
        r = c = (size + 1) / 2;
        star(N);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                sb.append(stars[i][j]);
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private static void star(int n) {
        if (n == 1) {
            stars[r][c] = '*';
        } else {
            int h = 4 * (n - 1) + 1;
            for (int i = 1; i <= h; i++) {
                if (i == 1 || i == h) {
                    for (int j = 1; j <= h; j++) {
                        stars[r - (h + 1) / 2 + i][c - (h + 1) / 2 + j] = '*';
                    }
                } else {
                    stars[r - (h + 1) / 2 + i][c - (h + 1) / 2 + 1] = '*';
                    stars[r - (h + 1) / 2 + i][c + (h + 1) / 2 - 1] = '*';
                }
            }
            star(n - 1);
        }
    }
}
