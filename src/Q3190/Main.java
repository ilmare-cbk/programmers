package Q3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 뱀
 */
public class Main {
    private static int N;
    private static int answer = 0;
    private static boolean[][] map;
    private static Deque<Snake> deque = new ArrayDeque<>();
    private static Map<Integer, String> commands = new HashMap<>();
    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new boolean[N + 1][N + 1];
        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = true; // 사과 위치 표시
        }
        int L = Integer.parseInt(br.readLine());
        commands = new HashMap<>();
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            commands.put(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        deque.addFirst(new Snake(1, 1));
        move(1, 2, 0);
        System.out.println(answer);
    }

    private static void move(int r, int c, int direction) {
        answer++;

        if (isWall(r, c) || isBody(r, c)) {
            return;
        }

        deque.addFirst(new Snake(r, c));

        // 사과가 있는 경우
        if (map[r][c]) {
            map[r][c] = false;
        } else {
            deque.removeLast();
        }

        if (commands.containsKey(answer)) {
            String command = commands.get(answer);
            int[] d = getDirection(r, c, direction, command);
            move(d[0], d[1], d[2]);
        } else {
            r = r + directions[direction][0];
            c = c + directions[direction][1];
            move(r, c, direction);
        }
    }

    private static int[] getDirection(int r, int c, int curDirection, String command) {
        if (command.equals("D")) {
            curDirection++;
            curDirection = curDirection % 4;
        } else {
            curDirection--;
            if (curDirection < 0) {
                curDirection = 3;
            }
            curDirection = curDirection % 4;
        }
        int[] d = directions[curDirection];
        return new int[]{r + d[0], c + d[1], curDirection};
    }

    private static boolean isWall(int r, int c) {
        return !(r > 0 && r <= N && c > 0 && c <= N);
    }

    private static boolean isBody(int r, int c) {
        return deque.contains(new Snake(r, c));
    }

    private static class Snake {
        int r;
        int c;

        public Snake(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Snake snake = (Snake) o;
            return r == snake.r && c == snake.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }
}
