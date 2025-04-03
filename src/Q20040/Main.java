package Q20040;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사이클 게임
 */
public class Main {
    private static int[] parent, rank;
    private static boolean cycle = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        int i;
        for (i = 1; i <= m; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st1.nextToken());
            int n2 = Integer.parseInt(st1.nextToken());
            union(n1, n2);
            if (cycle) break;
        }
        System.out.println(cycle ? i : 0);
    }

    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (rank[x] < rank[y]) {
                parent[x] = y;
            } else if (rank[x] > rank[y]) {
                parent[y] = x;
            } else {
                parent[y] = x;
                rank[x]++;
            }
        } else {
            cycle = true;
        }
    }
}
