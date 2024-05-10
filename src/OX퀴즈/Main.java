package OX퀴즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String result = br.readLine();
            int count = 0;
            int answer = 0;
            for (int j = 0; j < result.length(); j++) {
                if (result.charAt(j) == 'O') {
                    count++;
                    answer += count;
                } else {
                    count = 0;
                }
            }
            sb.append(answer).append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
