package 별찍기9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 2 * N - 1; i++) {
            if (i <= N) {
                for (int j = 1; j < i; j++) {
                    sb.append(" ");
                }
                for (int k = 1; k <= 2 * (N - i) + 1; k++) {
                    sb.append("*");
                }
            } else {
                for (int j = 1; j < 2 * N - i; j++) {
                    sb.append(" ");
                }
                for (int k = 1; k <= 2 * (i - N) + 1; k++) {
                    sb.append("*");
                }
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
