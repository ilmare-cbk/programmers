package Q10775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 공항
 */
public class Main {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        parent = new int[G + 1];
        for (int i = 1; i <= G; i++) {
            parent[i] = i;
        }
        int[] plights = new int[P + 1];
        for (int i = 0; i < P; i++) {
            plights[i + 1] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for (int i = 1; i <= P; i++) {
            int p = find(plights[i]);

            if (p == 0) {
                break;
            }

            cnt++;
            union(p - 1, p);
        }

        System.out.println(cnt);
    }

    private static void union(int x, int y) {
        int rootA = find(x);
        int rootB = find(y);

        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }

    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
