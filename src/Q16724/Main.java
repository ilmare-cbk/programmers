package Q16724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 피리 부는 사나이
 */
public class Main {
    private static char[][] map;
    private static boolean[][] visited;
    private static boolean[][] saved;
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        saved = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) dfs2(i, j);
            }
        }
        System.out.println(cnt);
    }

    // dfs 재귀 방식
    private static void dfs(int i, int j) {
        if (visited[i][j]) {
            if (!saved[i][j]) {
                cnt++;
            }
        } else {
            visited[i][j] = true;
            switch (map[i][j]) {
                case 'U':
                    dfs(i - 1, j);
                    break;
                case 'D':
                    dfs(i + 1, j);
                    break;
                case 'L':
                    dfs(i, j - 1);
                    break;
                default:
                    dfs(i, j + 1);
                    break;
            }
            saved[i][j] = true;
        }
    }

    // dfs 스택 방식
    private static void dfs2(int i, int j) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i, j});

        while (!stack.isEmpty()) {
            int[] node = stack.peek();
            int x = node[0];
            int y = node[1];

            if (visited[x][y]) {
                if (!saved[x][y]) cnt++;
                while (!stack.isEmpty()) {
                    int[] n = stack.pop();
                    saved[n[0]][n[1]] = true;
                }
            } else {
                visited[x][y] = true;
                switch (map[x][y]) {
                    case 'U':
                        stack.push(new int[]{x - 1, y});
                        break;
                    case 'D':
                        stack.push(new int[]{x + 1, y});
                        break;
                    case 'L':
                        stack.push(new int[]{x, y - 1});
                        break;
                    default:
                        stack.push(new int[]{x, y + 1});
                        break;
                }
            }
        }
    }
}
/*
3 4
DLLL
DRLL
RRRU

3 4
DLDL
RURU
RRRL
 */