package Q11729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 하노이 탑 이동 순서
 */
public class Main {
    private static int cnt = 0;
    private static int N;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        move(N, 1, 2, 3);
        System.out.println(cnt);
        System.out.println(sb);
    }

    private static void move(int n, int current, int mid, int target) {
        cnt++;
        if (n == 1) {
            sb.append(current).append(" ").append(target).append(System.lineSeparator());
        } else {
            move(n - 1, current, target, mid);
            sb.append(current).append(" ").append(target).append(System.lineSeparator());
            move(n - 1, mid, current, target);
        }
    }
}
