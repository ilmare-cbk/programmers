package Q17070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 파이프 옮기기 1
 */
public class Main {
    private static int N;
    private static int[][] map;
    private static int answer = 0;
    private static Queue<Location> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            String[] data = br.readLine().split(" ");
            for (int j = 0; j < data.length; j++) {
                map[i][j + 1] = Integer.parseInt(data[j]);
            }
        }
        queue.add(new Location(1, 2, -1));

        while (!queue.isEmpty()) {
            Location location = queue.poll();
            int r = location.r;
            int c = location.c;

            if (r == N && c == N) {
                answer++;
            }

            int status = location.status;
            // 가로일 때
            if (status == -1) {
                // 가로 이동
                if (((r < N && c + 1 < N) || (r == N && c + 1 <= N)) && map[r][c + 1] == 0) {
                    queue.add(new Location(r, c + 1, -1));
                }
                // 대각선 이동
                if (c + 1 <= N && r + 1 <= N && map[r][c + 1] == 0 && map[r + 1][c] == 0 && map[r + 1][c + 1] == 0) {
                    queue.add(new Location(r + 1, c + 1, 0));
                }
            }
            // 대각선일 때
            else if (status == 0) {
                // 가로 이동
                if (((r < N && c + 1 < N) || (r == N && c + 1 <= N)) && map[r][c + 1] == 0) {
                    queue.add(new Location(r, c + 1, -1));
                }
                // 세로 이동
                if (((c < N && r + 1 < N) || (c == N && r + 1 <= N)) && map[r + 1][c] == 0) {
                    queue.add(new Location(r + 1, c, 1));
                }
                // 대각선 이동
                if (r + 1 <= N && c + 1 <= N && map[r][c + 1] == 0 && map[r + 1][c] == 0 && map[r + 1][c + 1] == 0) {
                    queue.add(new Location(r + 1, c + 1, 0));
                }
            }
            // 세로일 때
            else {
                // 세로 이동
                if (((c < N && r + 1 < N) || (c == N && r + 1 <= N)) && map[r + 1][c] == 0) {
                    queue.add(new Location(r + 1, c, 1));
                }
                // 대각선 이동
                if (r + 1 <= N && c + 1 <= N && map[r][c + 1] == 0 && map[r + 1][c] == 0 && map[r + 1][c + 1] == 0) {
                    queue.add(new Location(r + 1, c + 1, 0));
                }
            }
        }
        System.out.println(answer);
    }

    private static class Location {
        int r;
        int c;
        int status; // -1 : 가로, 0 : 대각선, 1 : 세로

        public Location(int r, int c, int status) {
            this.r = r;
            this.c = c;
            this.status = status;
        }
    }
}