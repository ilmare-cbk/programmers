package 헌내기는친구가필요해;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int answer = 0;
    private static int N;
    private static int M;
    private static boolean[][] checked;
    private static String[][] campus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        campus = new String[N][M];
        checked = new boolean[N][M];
        int x = 0;
        int y = 0;
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                campus[i][j] = str[j];
                if (campus[i][j].equals("I")) {
                    x = i;
                    y = j;
                }
            }
        }
        traverse(x, y);
        System.out.println(answer == 0 ? "TT" : answer);
    }

    private static void traverse(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M || checked[x][y] || campus[x][y].equals("X")) {
            return;
        }
        checked[x][y] = true;
        if (campus[x][y].equals("P")) {
            answer++;
        }
        traverse(x + 1, y);
        traverse(x, y + 1);
        traverse(x - 1, y);
        traverse(x, y - 1);
    }
}
