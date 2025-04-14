package Q16724_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 피리 부는 사나이 (분리집합)
 */
public class Main {
    private static char[][] map;
    private static int[] parent;
    private static int N, M, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        parent = new int[N * M];

        for (int i = 0; i < N * M; i++) parent[i] = i;

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int cur = getIdx(i, j);
                int[] next = move(i, j);
                int nxt = getIdx(next[0], next[1]);
                union(cur, nxt);
            }
        }

        System.out.println(cnt);
    }

    private static int getIdx(int i, int j) {
        return i * M + j;
    }

    private static int[] move(int i, int j) {
        switch (map[i][j]) {
            case 'U':
                return new int[]{i - 1, j};
            case 'D':
                return new int[]{i + 1, j};
            case 'L':
                return new int[]{i, j - 1};
            default:
                return new int[]{i, j + 1};
        }
    }

    private static void union(int cur, int nxt) {
        int rootA = find(cur);
        int rootB = find(nxt);

        if (rootA == rootB) {
            cnt++;
        } else {
            parent[rootB] = rootA;
        }
    }

    private static int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }
}
