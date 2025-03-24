package Q1865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 웜홀
 */
public class Main {
    private static int TC;
    private static final int MAX = 5_000_000;
    private static List<E>[] edges;
    private static int[] dist;
    private static int N;
    private static int M;
    private static int W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (TC-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            edges = new List[N];
            dist = new int[N];
            for (int i = 0; i < N; i++) {
                edges[i] = new ArrayList<>();
            }
            for (int i = 0; i < M; i++) {
                StringTokenizer m = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(m.nextToken()) - 1;
                int v = Integer.parseInt(m.nextToken()) - 1;
                int w = Integer.parseInt(m.nextToken());
                edges[u].add(new E(v, w));
                edges[v].add(new E(u, w));
            }
            for (int i = 0; i < W; i++) {
                StringTokenizer h = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(h.nextToken()) - 1;
                int v = Integer.parseInt(h.nextToken()) - 1;
                int w = Integer.parseInt(h.nextToken());
                edges[u].add(new E(v, -w));
            }
            sb.append(bellmanFord() ? "YES" : "NO").append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private static boolean bellmanFord() {
        Arrays.fill(dist, MAX);
        dist[0] = 0;
        boolean update = false;

        for (int i = 0; i < N - 1; i++) {
            update = false;

            for (int j = 0; j < N; j++) {
                for (E e : edges[j]) {
                    if (dist[e.v] > dist[j] + e.w) {
                        dist[e.v] = dist[j] + e.w;
                        update = true;
                    }
                }
            }

            if (!update) {
                break;
            }
        }
        if (update) {
            for (int i = 0; i < N; i++) {
                for (E e : edges[i]) {
                    if (dist[e.v] > dist[i] + e.w) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static class E {
        int v;
        int w;

        public E(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
