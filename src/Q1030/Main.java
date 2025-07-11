package Q1030;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 프렉탈 평면
 */
public class Main {
    private static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int R1 = Integer.parseInt(st.nextToken());
        int R2 = Integer.parseInt(st.nextToken());
        int C1 = Integer.parseInt(st.nextToken());
        int C2 = Integer.parseInt(st.nextToken());

        int len = (int) Math.pow(N, s); // 프렉탈 평면 길이
        StringBuilder sb = new StringBuilder();
        for (int i = R1; i <= R2; i++) {
            for (int j = C1; j <= C2; j++) {
                sb.append(color(len, i, j));
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private static int color(int len, int r, int c) {
        int rb = 0, cb = 0; // 기준점
        while (len > 1) {
            // 중앙
            int blackLen = K * (len / N); // 프렉탈 평면 중앙(검정영역) 길이
            int gap = (len - blackLen) / 2;
            if (r >= rb + gap && r < rb + gap + blackLen && c >= cb + gap && c < cb + gap + blackLen) {
                return 1;
            }
            // 축소 (기준점 변경)
            len = len / N;
            rb += len * ((r - rb) / len);
            cb += len * ((c - cb) / len);
        }
        return 0; // 흰색
    }
}
