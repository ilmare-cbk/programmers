package Q15489;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 파스칼 삼각형
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[][] arr = new int[R + W + 1][R + W + 1];
        arr[1][1] = 1;

        for (int i = 1; i <= R + W; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
            }
        }

        int size = 0;
        for (int i = R; i < R + W; i++) {
            for (int j = C; j <= C + i - R; j++) {
                size += arr[i][j];
            }
        }

        System.out.println(size);
    }
}
