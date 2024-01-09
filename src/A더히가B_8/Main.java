package A더히가B_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final String RESULT = "Case #%d: %d + %d = %d";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            String input = br.readLine();
            int a = input.charAt(0) - '0';
            int b = input.charAt(2) - '0';
            sb.append(String.format(RESULT, i, a, b, a + b)).append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
