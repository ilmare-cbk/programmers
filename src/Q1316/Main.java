package Q1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 그룹 단어 체커
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (N-- > 0) {
            String line = br.readLine();
            boolean[] character = new boolean[26];
            boolean group = true;

            char c = line.charAt(0);
            character[c - 'a'] = true;

            for (int j = 1; j < line.length(); j++) {
                char nxt = line.charAt(j);
                if (nxt != c && character[nxt - 'a']) {
                    group = false;
                    break;
                }
                c = nxt;
                character[c - 'a'] = true;
            }
            if (group) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
