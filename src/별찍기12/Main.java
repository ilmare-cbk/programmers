package 별찍기12;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 2 * N - 1; i++) {
            int j;
            for (j = 1; j <= Math.abs(N - i); j++) {
                sb.append(" ");
            }
            for (int k = 1; k <= Math.abs(N - j + 1); k++) {
                sb.append("*");
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
