package Q5525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * IOIOI
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();
        int answer = 0;
        String pattern = makePattern(N);
        int[] pi = makeTable(pattern);

        int begin = 0;
        int matched = 0;

        while (begin + matched < M) {
            if (matched < pattern.length() && S.charAt(begin + matched) == pattern.charAt(matched)) {
                matched++;
                if (matched == pattern.length()) {
                    answer++;
                }
            } else {
                if (matched == 0) {
                    begin++;
                } else {
                    begin += matched - pi[matched - 1];
                    matched = pi[matched - 1];
                }
            }
        }

        System.out.println(answer);
    }

    private static int[] makeTable(String pattern) {
        int[] pi = new int[pattern.length()];
        int begin = 1;
        int matched = 0;
        int m = pattern.length();

        while (begin + matched < m) {
            if (pattern.charAt(begin + matched) == pattern.charAt(matched)) {
                matched++;
                pi[begin + matched - 1] = matched;
            } else {
                if (matched == 0) {
                    begin++;
                } else {
                    begin += matched - pi[matched - 1];
                    matched = pi[matched - 1];
                }
            }
        }

        return pi;
    }

    private static String makePattern(int N) {
        StringBuilder sb = new StringBuilder();
        String it = "OI";
        sb.append("I");

        for (int i = 0; i < N; i++) {
            sb.append(it);
        }

        return sb.toString();
    }
}
