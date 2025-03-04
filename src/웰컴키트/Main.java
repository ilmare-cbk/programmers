package 웰컴키트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] applicants = br.readLine().split(" ");
        String[] data = br.readLine().split(" ");
        int T = Integer.parseInt(data[0]);
        int P = Integer.parseInt(data[1]);
        StringBuilder sb = new StringBuilder();

        int sumT = 0;
        for (String applicant : applicants) {
            int n = Integer.parseInt(applicant);
            sumT += n % T == 0 ? n / T : (n / T) + 1;
        }

        sb.append(sumT)
                .append(System.lineSeparator())
                .append(N / P).append(" ")
                .append(N % P);
        System.out.println(sb);
    }
}
