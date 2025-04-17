package Q16946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 벽 부수고 이동하기 4
 */
public class Main {
    private static int N, M;
    private static int[][] map;
    private static Map<Integer, Integer> group = new HashMap<>();
    private static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int groupCount = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    group.put(groupCount, bfs(i, j, groupCount));
                    groupCount++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) map[i][j] = calculateMovableSize(i, j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] < 0) { // 그룹으로 활용했던 것은 0으로 다시 변경
                    sb.append(0);
                } else {
                    sb.append(map[i][j] % 10);
                }
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb);
    }

    private static int bfs(int x, int y, int groupCount) {
        int areaSize = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x * M + y);
        map[x][y] = -groupCount;

        while (!queue.isEmpty()) {
            int pos = queue.poll();
            int i = pos / M;
            int j = pos % M;


            for (int[] m : move) {
                int dx = i + m[0];
                int dy = j + m[1];
                if (isValid(dx, dy) && map[dx][dy] == 0) {
                    map[dx][dy] = -groupCount; // 그룹번호 설정
                    queue.add(dx * M + dy);
                    areaSize++; // 그룹의 영역 크기
                }
            }
        }

        return areaSize;
    }

    private static int calculateMovableSize(int i, int j) {
        Set<Integer> nearGroups = new HashSet<>();
        for (int[] m : move) {
            int dx = i + m[0];
            int dy = j + m[1];
            if (isValid(dx, dy) && map[dx][dy] < 0) {
                nearGroups.add(-map[dx][dy]);
            }
        }


        int movable = 1;
        for (Integer groupCount : nearGroups) {
            movable += group.get(groupCount);
        }

        return movable;
    }

    private static boolean isValid(int dx, int dy) {
        return dx >= 0 && dx < N && dy >= 0 && dy < M;
    }
}
