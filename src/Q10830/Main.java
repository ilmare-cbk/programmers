package Q10830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 행렬 제곱
 */
public class Main {
    private static int N;
    private static long B;
    private static final int MOD = 1_000;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st1.nextToken());
            }
        }
        int[][] result = pow(B);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j] % MOD).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private static int[][] pow(long b) {
        if (b == 1) {
            return arr;
        }

        int[][] temp = pow(b / 2);

        if (b % 2 == 1) {
            return cal(cal(temp, temp), arr);
        }

        return cal(temp, temp);
    }

    private static int[][] cal(int[][] a, int[][] b) {
        int[][] temp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int e = 0;
                for (int k = 0; k < N; k++) {
                    e += ((a[i][k] % MOD) * (b[k][j] % MOD)) % MOD;
                }
                temp[i][j] = e;
            }
        }
        return temp;
    }
}