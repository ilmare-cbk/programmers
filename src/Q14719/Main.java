package Q14719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 빗물
 */
public class Main {
    private static int W;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        arr = new int[H][W];
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < W; j++) {
            int h = Integer.parseInt(st.nextToken());
            for (int i = H - h; i < H; i++) {
                arr[i][j] = 1;
            }
        }
        int answer = 0;
        for (int i = 0; i < H; i++) {
            int w1 = findWall(i, 0);
            int w2 = findWall(i, w1 + 1);
            while (w2 < W) {
                answer += (w2 - w1 - 1);
                w1 = w2;
                w2 = findWall(i, w1 + 1);
            }
        }
        System.out.println(answer);
    }

    private static int findWall(int i, int j) {
        while (j < W) {
            if (arr[i][j] == 1) {
                return j;
            } else {
                j++;
            }
        }
        return j;
    }
}
