package Q14891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 톱니바퀴
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] gears = new int[4][8];
        for (int i = 0; i < 4; i++) {
            String[] gear = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                gears[i][j] = Integer.parseInt(gear[j]);
            }
        }
        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());
            if (idx == 0) {
                right(d, gears, idx);
            } else if (idx == 3) {
                left(d, gears, idx);
            } else {
                middle(d, gears, idx);
            }
        }
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            if (gears[i][0] == 1) {
                sum = (int) (sum + Math.pow(2, i));
            }
        }
        System.out.println(sum);
    }

    private static void middle(int d, int[][] gears, int idx) {
        if (idx > 0 && gears[idx][6] != gears[idx - 1][2]) {
            left(-d, gears, idx - 1);
        }
        if (idx < 3 && gears[idx][2] != gears[idx + 1][6]) {
            right(-d, gears, idx + 1);
        }
        turn(d, gears, idx);
    }

    private static void left(int d, int[][] gears, int idx) {
        if (idx > 0 && gears[idx][6] != gears[idx - 1][2]) {
            left(-d, gears, idx - 1);
        }
        turn(d, gears, idx);
    }

    private static void right(int d, int[][] gears, int idx) {
        if (idx < 3 && gears[idx][2] != gears[idx + 1][6]) {
            right(-d, gears, idx + 1);
        }
        turn(d, gears, idx);
    }

    private static void turn(int d, int[][] gears, int idx) {
        if (d == 1) {
            int prev = gears[idx][0];
            for (int i = 1; i < 8; i++) {
                int cur = gears[idx][i];
                gears[idx][i] = prev;
                prev = cur;
            }
            gears[idx][0] = prev;
        } else {
            int prev = gears[idx][0];
            for (int i = 7; i > 0; i--) {
                int cur = gears[idx][i];
                gears[idx][i] = prev;
                prev = cur;
            }
            gears[idx][0] = prev;
        }
    }
}
