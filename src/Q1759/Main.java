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

        dfs(0, 0, 0, "");
        System.out.println(sb);
    }

    private static void dfs(int idx, int c1, int c2, String s) {
        if (s.length() == L) {
            if (c1 >= 1 && c2 >= 2) sb.append(s).append(System.lineSeparator());
        } else {
            for (int i = idx; i <= C - (L - s.length()); i++) {
                String alphabet = alphabets[i];
                if (a.contains(alphabet)) {
                    dfs(i + 1, c1 + 1, c2, s + alphabet);
                } else {
                    dfs(i + 1, c1, c2 + 1, s + alphabet);
                }
            }
        }
    }
}
