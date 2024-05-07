package 숫자의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int R = A * B * C;
        String[] nums = String.valueOf(R).split("");
        int[] N = new int[10];
        for (String num : nums) {
            N[Integer.parseInt(num)] += 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int j : N) {
            sb.append(j).append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
