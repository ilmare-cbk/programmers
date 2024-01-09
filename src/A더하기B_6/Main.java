package A더하기B_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T > 0) {
            String input = br.readLine();
            int a = input.charAt(0) - '0';
            int b = input.charAt(2) - '0';
            sb.append(a + b).append(System.lineSeparator());
            T--;
        }
        System.out.println(sb);
    }
}
