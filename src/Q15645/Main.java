package Q15645;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 내려가기 2
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][3];
        int[][] max = new int[N][3];
        int[][] min = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            if (i == 0) {
                min[i][0] = max[i][0] = map[i][0];
                min[i][1] = max[i][1] = map[i][1];
                min[i][2] = max[i][2] = map[i][2];
            } else {
                max[i][0] = Math.max(max[i - 1][0], max[i - 1][1]) + map[i][0];
                max[i][1] = Math.max(max[i - 1][0], Math.max(max[i - 1][1], max[i - 1][2])) + map[i][1];
                max[i][2] = Math.max(max[i - 1][1], max[i - 1][2]) + map[i][2];

                min[i][0] = Math.min(min[i - 1][0], min[i - 1][1]) + map[i][0];
                min[i][1] = Math.min(min[i - 1][0], Math.min(min[i - 1][1], min[i - 1][2])) + map[i][1];
                min[i][2] = Math.min(min[i - 1][1], min[i - 1][2]) + map[i][2];
            }
        }

        System.out.println(Math.max(max[N - 1][0], Math.max(max[N - 1][1], max[N - 1][2])) + " " +
                Math.min(min[N - 1][0], Math.min(min[N - 1][1], min[N - 1][2])));
    }
}
