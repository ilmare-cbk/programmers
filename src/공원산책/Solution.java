package 공원산책;

import java.util.Arrays;

/**
 * input
 * - park : 공원을 나타내는 문자열 배열
 * - routes : 수행할 명령이 담긴 문자열 배열
 * 주어진 방향으로 이동할 때 공원을 벗어나는지 확인
 * 주어진 방향으로 이동할 때 장애물을 만나는지 확인
 * -> 두 가지 중 어느 하나라도 해당된다면 해당 명령어 무시하고, 다음 명령어 수행
 * 모든 명령어 수행 후 놓인 위치를 리턴
 */
public class Solution {
    private Position position;
    private static final String START = "S";
    private static final String BLOCK = "X";
    private static final String EAST = "E";
    private static final String WEST = "W";
    private static final String SOUTH = "S";

    public int[] solution(String[] park, String[] routes) {
        String[][] map = buildMap(park);
        return move(map, routes);
    }

    private String[][] buildMap(String[] park) {
        String[][] map = new String[park.length][park[0].length()];

        for (int i = 0; i < park.length; i++) {
            String[] spots = park[i].split("");
            for (int j = 0; j < spots.length; j++) {
                String spot = spots[j];
                storeIfStartPosition(spot, j, i);
                map[i][j] = spot;
            }
        }

        return map;
    }

    private int[] move(String[][] map, String[] routes) {
        for (String route : routes) {
            String[] command = route.split(" ");
            decideMovePosition(map, command);
        }
        return new int[]{position.y, position.x};
    }

    private void decideMovePosition(String[][] map, String[] command) {
        int x = position.x;
        int y = position.y;

        String direction = command[0];
        int moveCount = Integer.parseInt(command[1]);
        for (int i = 1; i <= moveCount; i++) {
            switch (direction) {
                case EAST:
                    x += 1;
                    break;
                case WEST:
                    x -= 1;
                    break;
                case SOUTH:
                    y += 1;
                    break;
                default:
                    y -= 1;
                    break;
            }
            if (!isMovable(map, x, y)) {
                return;
            }
        }
        position.move(x, y);
    }

    private boolean isMovable(String[][] map, int x, int y) {
        int w = map[0].length - 1;
        int h = map.length - 1;

        if (!isInside(w, h, x, y)) {
            return false;
        }

        return isRoute(map, x, y);
    }

    private boolean isInside(int w, int h, int x, int y) {
        return x >= 0 && x <= w && y >= 0 && y <= h;
    }

    private boolean isRoute(String[][] map, int x, int y) {
        return !map[y][x].equals(BLOCK);
    }

    private void storeIfStartPosition(String spot, int startX, int startY) {
        if (spot.equals(START)) {
            this.position = Position.of(startX, startY);
        }
    }

    private static class Position {
        private int x;
        private int y;

        private Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static Position of(int x, int y) {
            return new Position(x, y);
        }

        public void move(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
