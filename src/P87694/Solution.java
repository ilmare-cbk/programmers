package P87694;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 아이템 줍기
 */
public class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        System.out.println(
                solution(new int[][]{{2, 2, 5, 5},
                                {1, 3, 6, 4},
                                {3, 1, 4, 6}},
                        1, 4, 6, 3)
        );

//        System.out.println(
//                solution(new int[][]{{1, 1, 5, 7}},
//                        1, 1, 4, 7)
//        );

//        System.out.println(
//                solution(new int[][]{{25, 25, 50, 50}, {10, 10, 30, 35}, {20, 5, 40, 30}},
//                        50, 31, 10, 15)
//        );

//        System.out.println(
//                solution(new int[][]{{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}},
//                        1, 3, 3, 6)
//        );

    }

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        boolean[][] visited = new boolean[51][51];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{characterY, characterX, 0});
        visited[characterY][characterX] = true;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            if (pos[0] == itemY && pos[1] == itemX) {
                return pos[2];
            }

            for (int[] direction : directions) {
                int dy = pos[0] + direction[0];
                int dx = pos[1] + direction[1];

                if (isMovable(rectangle, pos[1], pos[0], dx, dy) && !visited[dy][dx]) {
                    visited[dy][dx] = true;
                    queue.add(new int[]{dy, dx, pos[2] + 1});
                }
            }

        }

        return answer;
    }

    private static boolean isMovable(int[][] rectangle, int fx, int fy, int tx, int ty) {
        boolean onLine = false;
        for (int[] rect : rectangle) {
            if (onLine(fx, fy, rect) && onLine(tx, ty, rect)) {
                onLine = true;
                break;
            }
        }

        if (!onLine) return false;

        for (int[] rect : rectangle) {
            if (inFace(fx, fy, tx, ty, rect)) {
                return false;
            }
        }

        return true;
    }

    private static boolean onLine(int x, int y, int[] rect) {
        return (x == rect[0] && y >= rect[1] && y <= rect[3]) ||
                (y == rect[1] && x >= rect[0] && x <= rect[2]) ||
                (x == rect[2] && y >= rect[1] && y <= rect[3]) ||
                (y == rect[3] && x >= rect[0] && x <= rect[2]);
    }

    private static boolean inFace(int fx, int fy, int tx, int ty, int[] rect) {
        if (rect[0] < tx && tx < rect[2] && rect[1] < ty && ty < rect[3] &&
                rect[0] < fx && fx < rect[2] && rect[1] < fy && fy < rect[3]) return true;

        if (fx == tx && rect[0] < fx && fx < rect[2]) {
            int minY = Math.min(fy, ty);
            int maxY = Math.max(fy, ty);
            return rect[1] <= minY && maxY <= rect[3];
        }

        if (fy == ty && rect[1] < fy && fy < rect[3]) {
            int minX = Math.min(fx, tx);
            int maxX = Math.max(fx, tx);
            return rect[0] <= minX && maxX <= rect[2];
        }

        return false;
    }
}
