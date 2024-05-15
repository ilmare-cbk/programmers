package 색종이만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int w = 0;
    private static int b = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = st.nextToken().equals("1");
            }
        }
        count(arr, 0, 0, N);
        System.out.println(w + System.lineSeparator() + b);
    }

    private static void count(boolean[][] arr, int x, int y, int d) {
        if (d == 0) {
            return;
        }
        boolean cur = arr[x][y];
        boolean same = true;
        for (int i = x; i < x + d; i++) {
            for (int j = y; j < y + d; j++) {
                if (cur != arr[i][j]) {
                    same = false;
                    break;
                }
            }
            if (!same) {
                break;
            }
        }
        if (same) {
            if (cur) {
                b++;
            } else {
                w++;
            }
        } else {
            int d1 = d / 2;
            count(arr, x, y, d1);
            count(arr, x + d1, y, d1);
            count(arr, x, y + d1, d1);
            count(arr, x + d1, y + d1, d1);
        }
    }
}
