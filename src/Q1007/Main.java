package Q1007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 벡터 매칭
 */
public class Main {
    private static double answer = Double.MAX_VALUE;
    private static int N;
    private static boolean[] select;
    private static int[][] vector;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            answer = Double.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            select = new boolean[N];
            vector = new int[N][2];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                vector[i][0] = Integer.parseInt(st.nextToken());
                vector[i][1] = Integer.parseInt(st.nextToken());
            }
            vectorSum(0, 0);
            sb.append(answer).append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private static void vectorSum(int idx, int selectCnt) {
        if (selectCnt == N / 2) {
            double x = 0, y = 0;
            for (int i = 0; i < N; i++) {
                if (select[i]) {
                    x += vector[i][0];
                    y += vector[i][1];
                } else {
                    x -= vector[i][0];
                    y -= vector[i][1];
                }
            }
            answer = Math.min(answer, Math.sqrt(x * x + y * y));
            return;
        }

        for (int i = idx; i < N; i++) {
            select[i] = true;
            vectorSum(i + 1, selectCnt + 1);
            select[i] = false;
        }
    }
}
/*
1
4
5 5
5 -5
-5 5
-5 -5
1
2
-100000 -100000
100000 100000
 */