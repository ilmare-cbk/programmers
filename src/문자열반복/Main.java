package 문자열반복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            int R = Integer.parseInt(input[0]);
            String[] S = input[1].split("");
            for (String s : S) {
                for (int r = 0; r < R; r++) {
                    sb.append(s);
                }
            }
            System.out.println(sb);
            sb.setLength(0);
        }
    }
}
