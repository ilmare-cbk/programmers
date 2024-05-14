package 바이러스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] virus;
    private static boolean[] check;
    private static int count = 0;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        virus = new int[N + 1][N + 1];
        check = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            virus[a][b] = virus[b][a] = 1;
        }
        traverse(1);
        System.out.println(count - 1);
    }

    private static void traverse(int node) {
        check[node] = true;
        count++;

        for (int i = 1; i <= N; i++) {
            if (virus[node][i] == 1 && !check[i]) {
                traverse(i);
            }
        }
    }
}
