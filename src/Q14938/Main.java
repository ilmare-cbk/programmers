package Q14938;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 서강그라운드
 */
public class Main {
    private static int n; // 지역의 갯수
    private static int m; // 수색범위
    private static int r; // 길의 갯수
    private static int[] items; // 아이템 갯수
    private static int[][] map;
    private static final int MAX_LENGTH = 1_500;
    private static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        items = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    map[i][j] = MAX_LENGTH;
                }
            }
        }
        StringTokenizer it = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            items[i] = Integer.parseInt(it.nextToken());
        }
        for (int i = 0; i < r; i++) {
            StringTokenizer data = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(data.nextToken()) - 1;
            int b = Integer.parseInt(data.nextToken()) - 1;
            int l = Integer.parseInt(data.nextToken());
            map[a][b] = l;
            map[b][a] = l;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (k != i && k != j) {
                        map[j][i] = map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int result = 0;
            for (int j = 0; j < n; j++) {
                if (map[i][j] <= m) {
                    result += items[j];
                }
            }
            answer = Math.max(answer, result);
        }
        System.out.println(answer);
    }
}