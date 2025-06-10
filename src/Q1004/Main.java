package Q1004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 어린 왕자
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
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(br.readLine());
            int sum = 0;
            while (n-- > 0) {
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                boolean b1 = inCircle(x1, y1, cx, cy, r);
                boolean b2 = inCircle(x2, y2, cx, cy, r);
                if ((b1 && !b2) || (!b1 && b2)) {
                    sum++;
                }
            }
            sb.append(sum).append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private static boolean inCircle(int x, int y, int cx, int cy, int r) {
        return Math.pow(x - cx, 2) + Math.pow(y - cy, 2) < Math.pow(r, 2);
    }
}
