package Q1002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 터렛
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            double d = distance(x1, y1, x2, y2);
            int R = Math.max(r1, r2);
            int r = Math.min(r1, r2);
            if (Math.pow(R - r, 2) < d && d < Math.pow(r1 + r2, 2)) {
                sb.append(2);
            } else if (d == Math.pow(r1 + r2, 2) || (R != r && d == Math.pow(R - r, 2))) {
                sb.append(1);
            } else if (d > Math.pow(r1 + r2, 2) || (R != r && d < Math.pow(R - r, 2))) {
                sb.append(0);
            } else {
                sb.append(-1);
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private static double distance(int x1, int y1, int x2, int y2) {
        return Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);
    }
}
