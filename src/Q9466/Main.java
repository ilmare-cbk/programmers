package Q9466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 텀 프로젝트
 */
public class Main {
    private static int[] students;
    private static boolean[] visited;
    private static boolean[] decided;
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            students = new int[n + 1];
            visited = new boolean[n + 1];
            decided = new boolean[n + 1];
            cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                students[i + 1] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < n; i++) {
                if (!visited[i + 1]) dfs(i + 1);
            }

            sb.append(n - cnt).append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private static void dfs(int i) {
        if (visited[i]) {
            if (!decided[i]) {
                cnt++;
                int next = students[i];
                while (next != i) {
                    cnt++;
                    next = students[next];
                }
            }
        } else {
            visited[i] = true;
            dfs(students[i]);
            decided[i] = true;
        }
    }
}