package Q15652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * N과 M (4)
 */
public class Main {
    private static int N;
    private static int M;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        search(1, 0, "");
        System.out.println(sb);
    }

    private static void search(int n, int length, String s) {
        if (length == M) {
            sb.append(s).append(System.lineSeparator());
            return;
        }

        for (int i = n; i <= N; i++) {
            search(i, length + 1, s + i + " ");
        }
    }
}
