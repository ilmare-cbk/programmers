package P72413;

import java.util.Arrays;

/**
 * 합승 택시 요금
 */
public class Solution {
    private static final int INF = 20_000_000;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = INF;
        int[][] dist = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0; // 같은 정점까지의 거리는 0으로 설정
        }

        for (int[] fare : fares) {
            int v1 = fare[0];
            int v2 = fare[1];
            int cost = fare[2];
            dist[v1][v2] = cost;
            dist[v2][v1] = cost;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        answer = Math.min(answer, dist[s][a] + dist[s][b]);
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, dist[s][i] + dist[i][a] + dist[i][b]);
        }

        return answer;
    }
}
