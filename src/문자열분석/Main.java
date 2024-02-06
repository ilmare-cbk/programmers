package 문자열분석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringBuilder sb = new StringBuilder();
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            int lower = 0, upper = 0, digit = 0, empty = 0;
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c >= 'A' && c <= 'Z') {
                    upper++;
                } else if (c >= 'a' && c <= 'z') {
                    lower++;
                } else if (c >= '0' && c <= '9') {
                    digit++;
                } else {
                    empty++;
                }
            }
            sb.append(lower).append(" ")
                    .append(upper).append(" ")
                    .append(digit).append(" ")
                    .append(empty).append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
