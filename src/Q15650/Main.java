package Q15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * N과 M (2)
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

        search(0, 0, "");

        System.out.println(sb);
    }

    private static void search(int i, int length, String s) {
        if (length == M) {
            sb.append(s).append(System.lineSeparator());
            return;
        }

        for (int j = i + 1; j <= N - (M - length - 1); j++) {
            search(j, length + 1, s + j + " ");
        }
    }
}
