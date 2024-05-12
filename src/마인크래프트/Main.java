package 마인크래프트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int max = 0;
        int min = 256;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
                min = Math.min(min, map[i][j]);
            }
        }

        int time = Integer.MAX_VALUE;
        int height = 0;
        for (int h = min; h <= max; h++) {
            int inventory = B;
            int minTime = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    int curHeight = map[j][k];
                    if (curHeight > h) {
                        minTime += 2 * (curHeight - h);
                        inventory += curHeight - h;
                    } else if (curHeight < h) {
                        minTime += h - curHeight;
                        inventory -= h - curHeight;
                    }
                }
            }
            if (inventory >= 0) {
                if (time > minTime) {
                    time = minTime;
                    height = h;
                } else if (time == minTime) {
                    height = Math.max(height, h);
                }
            }
        }
        System.out.println(time + " " + height);
    }
}
