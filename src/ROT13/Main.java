package ROT13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (isAlphabet(c, 'A', 'Z')) {
                appendByROT13(c, 'Z', sb, 'A');
            } else if (isAlphabet(c, 'a', 'z')) {
                appendByROT13(c, 'z', sb, 'a');
            } else {
                sb.append(c);
            }
        }
        System.out.println(sb);
    }

    private static boolean isAlphabet(char c, char A, char Z) {
        return c >= A && c <= Z;
    }

    private static void appendByROT13(char c, char Z, StringBuilder sb, char A) {
        if (c + 13 > Z) {
            sb.append((char) (c + 13 - Z + A - 1));
        } else {
            sb.append((char) (c + 13));
        }
    }
}
