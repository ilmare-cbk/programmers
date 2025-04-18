package Q17387;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 선분 교차 2
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] L = new int[2][4];

        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                L[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(isIntersect(L) ? 1 : 0);

    }

    private static boolean isIntersect(int[][] L) {
        int x1 = L[0][0], y1 = L[0][1], x2 = L[0][2], y2 = L[0][3];
        int x3 = L[1][0], y3 = L[1][1], x4 = L[1][2], y4 = L[1][3];

        long abc = ccw(x1, y1, x2, y2, x3, y3);
        long abd = ccw(x1, y1, x2, y2, x4, y4);
        long cda = ccw(x3, y3, x4, y4, x1, y1);
        long cdb = ccw(x3, y3, x4, y4, x2, y2);

        if ((abc == 0 || abd == 0) && (cda == 0 || cdb == 0)) {
            if (Math.max(x1, x2) < Math.min(x3, x4)) return false;
            if (Math.max(x3, x4) < Math.min(x1, x2)) return false;
            if (Math.max(y1, y2) < Math.min(y3, y4)) return false;
            return Math.max(y3, y4) >= Math.min(y1, y2);
        }

        return ((abc <= 0 && abd >= 0) || (abc >= 0 && abd <= 0)) &&
                ((cda <= 0 && cdb >= 0) || (cda >= 0 && cdb <= 0));
    }

    private static long ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (long) (x2 - x1) * (y3 - y1) - (long) (y2 - y1) * (x3 - x1);
    }
}
