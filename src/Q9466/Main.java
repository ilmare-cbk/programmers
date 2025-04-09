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
    private static boolean[] team;
    private static int[] path;
    private static int pathSize;
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            students = new int[n + 1];
            visited = new boolean[n + 1];
            team = new boolean[n + 1];
            path = new int[n + 1];
            cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                students[i + 1] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < n; i++) {
                pathSize = 0;
                if (!visited[i + 1]) dfs(i + 1);
            }

            sb.append(n - cnt).append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private static void dfs(int i) {
        if (visited[i]) {
            if (!team[i]) {
                for (int s = 0; s < pathSize; s++) {
                    if (path[s] == i) {
                        for (int j = s; j < pathSize; j++) {
                            team[path[j]] = true;
                            cnt++;
                        }
                        break;
                    }
                }
            }
            return;
        }

        visited[i] = true;
        path[pathSize++] = i;
        dfs(students[i]);
    }
}
