package Q12904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A와 B
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringBuilder T = new StringBuilder(br.readLine());

        while (T.length() > S.length()) {
            char last = T.charAt(T.length() - 1);
            T.deleteCharAt(T.length() - 1);
            if (last == 'B') {
                T.reverse();
            }
        }

        System.out.println(T.toString().equals(S) ? 1 : 0);
    }
}