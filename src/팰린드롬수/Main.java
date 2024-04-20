package 팰린드롬수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        boolean palindrome;
        while (!(input = br.readLine()).equals("0")) {
            palindrome = true;
            for (int i = 0; i < input.length() / 2; i++) {
                if (!palindrome) {
                    break;
                }
                palindrome = input.charAt(i) == input.charAt(input.length() - i - 1);
            }
            sb.append(palindrome ? "yes" : "no").append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
