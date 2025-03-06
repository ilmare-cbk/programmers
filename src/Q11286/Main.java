package Q11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 절댓값 힙
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Number> q = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (q.isEmpty() && input == 0) {
                sb.append(input).append(System.lineSeparator());
            }
            if (!q.isEmpty() && input == 0) {
                sb.append(q.poll().getNum()).append(System.lineSeparator());
            }
            if (input != 0) {
                q.add(new Number(input));
            }
        }
        System.out.println(sb);
    }

    private static class Number implements Comparable<Number> {
        private final int num;

        public Number(int num) {
            this.num = num;
        }

        public int getNum() {
            return num;
        }

        @Override
        public int compareTo(Number o) {
            if (Math.abs(this.num) > Math.abs(o.num)) {
                return 1;
            } else if (Math.abs(this.num) < Math.abs(o.num)) {
                return -1;
            } else {
                return Integer.compare(this.num, o.num);
            }
        }
    }
}
