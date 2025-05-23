package Q21608;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 상어 초등학교
 */
public class Main {
    private static int N;
    private static Map<Integer, int[]> studentNumPosition = new HashMap<>();
    private static int[][] adjacentCnt;
    private static List<int[]> likes;
    private static final int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        likes = new ArrayList<>();
        adjacentCnt = new int[N + 1][N + 1];
        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[5];
            for (int j = 0; j < 5; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            likes.add(arr);
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == 1 || i == N) {
                    if (j == 1 || j == N) {
                        adjacentCnt[i][j] = 2;
                    } else {
                        adjacentCnt[i][j] = 3;
                    }
                } else {
                    if (j == 1 || j == N) {
                        adjacentCnt[i][j] = 3;
                    } else {
                        adjacentCnt[i][j] = 4;

                    }
                }
            }
        }

        for (int i = 0; i < N * N; i++) {
            int[] arr = likes.get(i);
            int cur = arr[0];
            int[] pos = findPos(arr);
            studentNumPosition.put(cur, pos);
            map[pos[0]][pos[1]] = cur;
            decreaseAdjacentCnt(pos[0], pos[1]);
        }

        int answer = 0;
        for (int i = 0; i < N * N; i++) {
            int[] arr = likes.get(i);
            int student = arr[0];
            int[] pos = studentNumPosition.get(student);
            Set<Integer> likeNum = new HashSet<>();
            for (int[] d : direction) {
                int r = pos[0] + d[0];
                int c = pos[1] + d[1];
                if (isValid(r, c)) {
                    likeNum.add(map[r][c]);
                }
            }
            int sum = 0;
            for (int j = 1; j <= 4; j++) {
                if (likeNum.contains(arr[j])) {
                    sum++;
                }
            }
            answer = answer + (sum == 0 ? 0 : (int) Math.pow(10, sum - 1));
        }

        System.out.println(answer);
    }

    private static void decreaseAdjacentCnt(int i, int j) {
        for (int[] d : direction) {
            int r = i + d[0];
            int c = j + d[1];
            if (isValid(r, c)) {
                adjacentCnt[r][c]--;
            }
        }
    }

    private static int[] findPos(int[] arr) {
        int maxAdjacent = 0;
        int maxAdjacentEmpty = 0;
        int r = 0, c = 0;
        Map<Integer, Integer> adjacent = new HashMap<>();

        for (int j = 1; j <= 4; j++) {
            int like = arr[j];
            if (!studentNumPosition.containsKey(like)) continue;
            int[] pos = studentNumPosition.get(like);
            for (int[] d : direction) {
                int dr = pos[0] + d[0];
                int dc = pos[1] + d[1];
                if (isValid(dr, dc) && map[dr][dc] == 0) {
                    int key = dr * 20 + dc;
                    Integer adjacentCnt = adjacent.getOrDefault(key, 0);
                    adjacent.put(key, adjacentCnt + 1);
                    if (adjacentCnt + 1 > maxAdjacent) {
                        maxAdjacent = adjacentCnt + 1;
                        r = dr;
                        c = dc;
                        maxAdjacentEmpty = getEmptyCnt(dr, dc);
                    } else if (adjacentCnt + 1 == maxAdjacent) {
                        int emptyCnt = getEmptyCnt(dr, dc);
                        if (emptyCnt > maxAdjacentEmpty) {
                            maxAdjacentEmpty = emptyCnt;
                            r = dr;
                            c = dc;
                        } else if (emptyCnt == maxAdjacentEmpty) {
                            if (dr < r) {
                                r = dr;
                                c = dc;
                            } else if (dr == r) {
                                if (dc < c) {
                                    c = dc;
                                }
                            }
                        }
                    }
                }
            }
        }

        if (r == 0 && c == 0) {
            int max = -1;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][j] != 0) continue;
                    int cnt = adjacentCnt[i][j];
                    if (cnt > max) {
                        max = cnt;
                        r = i;
                        c = j;
                    } else if (cnt == max) {
                        if (i < r) {
                            r = i;
                            c = j;
                        } else if (i == r) {
                            if (j < c) {
                                c = j;
                            }
                        }
                    }
                }
            }
        }
        return new int[]{r, c};
    }

    private static int getEmptyCnt(int dr, int dc) {
        int emptyCnt = 0;
        for (int[] d1 : direction) {
            int dr1 = dr + d1[0];
            int dc1 = dc + d1[1];
            if (isValid(dr1, dc1) && map[dr1][dc1] == 0) {
                emptyCnt++;
            }
        }
        return emptyCnt;
    }

    private static boolean isValid(int r, int c) {
        return r > 0 && r <= N && c > 0 && c <= N;
    }
}
