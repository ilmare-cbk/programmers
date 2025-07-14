package Q1033;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 칵테일
 */
public class Main {
    private static List<Integer>[] edges;
    private static int[] amounts;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        edges = new List[N];
        amounts = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            edges[i] = new ArrayList<>();
            amounts[i] = 1;
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            edges[n1].add(n2);
            edges[n2].add(n1);

            int n1Acc = p * amounts[n2];
            int n2Acc = q * amounts[n1];
            int gcd = gcd(p * amounts[n2], q * amounts[n1]);
            n1Acc = n1Acc / gcd;
            n2Acc = n2Acc / gcd;
            amounts[n1] *= n1Acc;
            amounts[n2] *= n2Acc;
            visited[n1] = true;
            visited[n2] = true;
            dfs(n1, n1Acc);
            dfs(n2, n2Acc);
            visited[n1] = false;
            visited[n2] = false;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(amounts[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static void dfs(int curGradient, int acc) {
        List<Integer> gradients = edges[curGradient];
        for (Integer gradient : gradients) {
            if (!visited[gradient]) {
                visited[gradient] = true;
                amounts[gradient] *= acc;
                dfs(gradient, acc);
                visited[gradient] = false;
            }
        }
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

}
/*
10
4 0 1 1
4 1 3 1
4 2 5 1
4 3 7 1
3 5 1 9
3 6 8 2
5 7 2 1
7 8 5 8
5 9 1 6

420 140 84 60 420 540 15 270 432 3240
 */