package Q9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문자열 폭발
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String bomb = br.readLine();

        StringBuilder sb = new StringBuilder();
        int bombLength = bomb.length();
        char lastBombChar = bomb.charAt(bombLength - 1);

        for (char c : input.toCharArray()) {
            sb.append(c);

            // 마지막 문자가 폭발 문자열의 마지막 문자와 일치할 때만 확인
            if (c == lastBombChar && sb.length() >= bombLength) {
                boolean match = true;
                for (int i = 0; i < bombLength; i++) {
                    if (sb.charAt(sb.length() - bombLength + i) != bomb.charAt(i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    sb.setLength(sb.length() - bombLength); // 폭발 문자열 제거
                }
            }
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb);
    }
}
