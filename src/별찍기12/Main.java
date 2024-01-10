package 별찍기12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 2 * N - 1; i++) {
            int j;
            for (j = 1; j <= Math.abs(N - i); j++) {
                sb.append(" ");
            }
            for (int k = 1; k <= Math.abs(N - j + 1); k++) {
                sb.append("*");
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
