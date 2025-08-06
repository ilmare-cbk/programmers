package P84021;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 퍼즐 조각 채우기
 */
public class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static List<Puzzle> puzzles = new ArrayList<>();
    private static int minR = 0, minC = 0;// 게임보드 빈 공간의 최소 r,c 좌표

    public static void main(String[] args) {
//        System.out.println(
//                solution(new int[][]{{1, 1, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 0, 1}, {1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 1, 0}, {0, 1, 1, 1, 0, 0}},
//                        new int[][]{{1, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 1, 0, 0, 0}, {1, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 0, 0}})
//        );

        System.out.println(
                solution(new int[][]{{0, 0, 0, 1}, {1, 1, 0, 1}, {1, 1, 0, 1}, {1, 1, 0, 1}},
                        new int[][]{{1, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 0}, {0, 0, 0, 0}})
        );
    }

    public static int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        int N = table.length;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (table[r][c] == 1) {
                    bfs(r, c, table);
                }
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (game_board[r][c] == 0) {
                    List<int[]> target = findEmpty(r, c, game_board);

                    for (Puzzle puzzle : puzzles) {
                        if (puzzle.used) continue;
                        if (puzzle.matched(target, minR, minC)) {
                            answer += puzzle.shape.size();
                            break;
                        }
                    }
                }
            }
        }
        return answer;
    }

    private static void bfs(int r, int c, int[][] table) {
        int minR = r, maxR = r;
        int minC = c, maxC = c;
        List<int[]> shape = new ArrayList<>();

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        table[r][c] = 0; // 방문처리

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            shape.add(pos);

            for (int[] direction : directions) {
                int dr = pos[0] + direction[0];
                int dc = pos[1] + direction[1];

                if (isMovable(dr, dc, table.length) && table[dr][dc] == 1) {
                    queue.add(new int[]{dr, dc});
                    table[dr][dc] = 0; // 방문 처리
                    minR = Math.min(minR, dr);
                    minC = Math.min(minC, dc);
                    maxR = Math.max(maxR, dr);
                    maxC = Math.max(maxC, dc);
                }
            }
        }

        puzzles.add(new Puzzle(Math.max(maxR - minR, maxC - minC) + 1, shape, minR, minC));
    }

    private static List<int[]> findEmpty(int r, int c, int[][] game_board) {
        List<int[]> result = new ArrayList<>();
        minR = r;
        minC = c;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        game_board[r][c] = 1; // 방문 처리

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            result.add(pos);

            for (int[] direction : directions) {
                int dr = pos[0] + direction[0];
                int dc = pos[1] + direction[1];

                if (isMovable(dr, dc, game_board.length) && game_board[dr][dc] == 0) {
                    queue.add(new int[]{dr, dc});
                    game_board[dr][dc] = 1; // 방문 처리
                    minR = Math.min(minR, dr);
                    minC = Math.min(minC, dc);
                }
            }
        }

        return result;
    }

    private static boolean isMovable(int r, int c, int N) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    private static class Puzzle {
        int size; // 퍼즐 조각을 회전시켰을 때 들어가는 격자 사이즈
        List<int[]> shape;
        boolean used;

        public Puzzle(int size, List<int[]> shape, int minR, int minC) {
            this.size = size;
            this.shape = convert(shape, minR, minC);
            this.used = false;
        }

        public boolean matched(List<int[]> targets, int minR, int minC) {
            if (targets.size() != shape.size()) return false;

            List<int[]> empties = convert(targets, minR, minC);
            List<int[]> puzzles = new ArrayList<>();
            for (int[] piece : shape) {
                puzzles.add(new int[]{piece[0], piece[1]});
            }

            int rotateCnt = 4;

            while (rotateCnt > 0) {
                int matchCnt = 0;
                for (int[] empty : empties) {
                    for (int[] puzzle : puzzles) {
                        if (empty[0] == puzzle[0] && empty[1] == puzzle[1]) {
                            matchCnt++;
                            break;
                        }
                    }
                }
                if (matchCnt == targets.size()) {
                    this.used = true;
                    return true;
                } else {
                    puzzles = rotate(puzzles);
                    rotateCnt--;
                }
            }
            return false;
        }

        /**
         * (r,c) -> (c, size - 1 - r)
         */
        private List<int[]> rotate(List<int[]> shape) {
            List<int[]> result = new ArrayList<>();
            int minR = Integer.MAX_VALUE, minC = Integer.MAX_VALUE;

            for (int[] piece : shape) {
                int r = piece[1];
                int c = size - 1 - piece[0];
                minR = Math.min(minR, r);
                minC = Math.min(minC, c);
                result.add(new int[]{r, c});
            }

            return convert(result, minR, minC);
        }

        /**
         * (0,0) 좌표 기준으로 변경
         */
        private List<int[]> convert(List<int[]> shape, int minR, int minC) {
            List<int[]> result = new ArrayList<>();
            for (int[] piece : shape) {
                result.add(new int[]{piece[0] - minR, piece[1] - minC});
            }
            return result;
        }
    }
}
