package Q16928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 뱀과 사다리 게임
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        Map<Integer, Integer> ladder = new HashMap<>();
        Map<Integer, Integer> snake = new HashMap<>();
        boolean[] visited = new boolean[101];
        int[] count = new int[101];

        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split(" ");
            ladder.put(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
        }

        for (int i = 0; i < M; i++) {
            String[] data = br.readLine().split(" ");
            snake.put(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[0] = true;

        while (!queue.isEmpty()) {
            Integer number = queue.poll();
            for (int i = 1; i <= 6; i++) {
                if (number + i == 100) {
                    count[number + i] = count[number] + 1;
                    System.out.println(count[100]);
                    return;
                } else if (number + i < 100) {
                    if (visited[number + i]) {
                        continue;
                    }
                    visited[number + i] = true;
                    count[number + i] = count[number] + 1;
                    if (ladder.get(number + i) != null) {
                        if (!visited[ladder.get(number + i)]) {
                            visited[ladder.get(number + i)] = true;
                            count[ladder.get(number + i)] = count[number] + 1;
                            queue.add(ladder.get(number + i));
                        }
                    } else if (snake.get(number + i) != null) {
                        if (!visited[snake.get(number + i)]) {
                            visited[snake.get(number + i)] = true;
                            count[snake.get(number + i)] = count[number] + 1;
                            queue.add(snake.get(number + i));
                        }
                    } else {
                        queue.add(number + i);
                    }
                }
            }
        }
    }
}
