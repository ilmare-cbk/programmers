package 그대로출력하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringBuilder sb = new StringBuilder();
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            sb.append(input).append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
