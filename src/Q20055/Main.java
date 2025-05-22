package Q20055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 컨베이어 벨트 위의 로봇
 */
public class Main {
    private static int N, K, D = 0;
    private static List<Integer> robots = new ArrayList<>();
    private static int[] container;
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        container = new int[2 * N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            container[i] = Integer.parseInt(st.nextToken());
        }
        move(0, N - 1);
        System.out.println(cnt);
    }

    private static void move(int up, int down) {
        cnt++;
        up = rotateUp(up);
        down = rotateDown(down);
        moveRobot(down);
        on(up);

        if (D >= K) return;
        move(up, down);
    }

    private static void moveRobot(int down) {
        for (int i = 0; i < robots.size(); i++) {
            Integer r = robots.get(i);
            int idx = (r + 1) % (2 * N);
            if (container[idx] > 0 && !robots.contains(idx)) {
                robots.set(i, idx);
                container[idx]--;
                if (container[idx] == 0) {
                    D++;
                }
            }
        }
        off(down);
    }

    private static void on(int up) {
        if (container[up] > 0) {
            robots.add(up);
            container[up]--;
            if (container[up] == 0) {
                D++;
            }
        }
    }

    private static int rotateDown(int down) {
        if (down == 0) down = 2 * N - 1;
        else down = down - 1;

        off(down);
        return down;
    }

    private static int rotateUp(int up) {
        if (up == 0) up = 2 * N - 1;
        else up = up - 1;
        return up;
    }

    private static void off(int down) {
        if (!robots.isEmpty() && robots.get(0) == down) {
            robots.remove(0);
        }
    }
}
