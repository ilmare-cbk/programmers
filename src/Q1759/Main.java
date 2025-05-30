package Q1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 암호 만들기
 */
public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int L, C;
    private static String[] alphabets;
    private static Set<String> a = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alphabets = br.readLine().split(" ");

        a.add("a");
        a.add("e");
        a.add("i");
        a.add("o");
        a.add("u");
        Arrays.sort(alphabets);

        password(0, 0, 0, "");
        System.out.println(sb);
    }

    /**
     *
     * @param idx
     * @param c1 사용된 모음 수
     * @param c2 사용된 자음 수
     * @param s 만들어진 문자열
     */
    private static void password(int idx, int c1, int c2, String s) {
        if (s.length() == L) {
            if (c1 >= 1 && c2 >= 2) sb.append(s).append(System.lineSeparator());
        } else {
            for (int i = idx; i <= C - (L - s.length()); i++) {
                String alphabet = alphabets[i];
                if (a.contains(alphabet)) {
                    password(i + 1, c1 + 1, c2, s + alphabet);
                } else {
                    password(i + 1, c1, c2 + 1, s + alphabet);
                }
            }
        }
    }
}
