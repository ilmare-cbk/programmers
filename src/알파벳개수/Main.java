package 알파벳개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringBuilder sb = new StringBuilder();
        int[] count = new int[26];
        for (int i = 0; i < S.length(); i++) {
            count[S.charAt(i) - 97]++;
        }
        for (int j : count) {
            sb.append(j).append(" ");
        }
        System.out.println(sb);

    }
}
