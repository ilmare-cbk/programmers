package Q2166;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 다각형의 면적
 */
public class Main {
    private static int N;
    private static int[][] pos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pos = new int[N + 1][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer xy = new StringTokenizer(br.readLine());
            pos[i][0] = Integer.parseInt(xy.nextToken());
            pos[i][1] = Integer.parseInt(xy.nextToken());
        }
        pos[N][0] = pos[0][0];
        pos[N][1] = pos[0][1];

        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += (long) pos[i][0] * pos[i + 1][1] - (long) pos[i + 1][0] * pos[i][1];
        }
        double area = Math.abs(sum) / 2.0;

        System.out.printf("%.1f", area);
    }
}
/*
4
-100000 -100000
100000 -100000
100000 100000
-100000 100000
 */