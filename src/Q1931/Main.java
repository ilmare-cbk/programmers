package Q1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 회의실 배정
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Meeting> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split(" ");
            queue.offer(new Meeting(Integer.parseInt(data[0]), Integer.parseInt(data[1])));
        }
        int answer = 0;
        int time = 0;
        for (int i = 0; i < N; i++) {
            Meeting meeting = queue.poll();
            if (time <= meeting.getS()) {
                answer++;
                time = meeting.getE();
            }
        }
        System.out.println(answer);;
    }

    private static class Meeting implements Comparable<Meeting> {
        private final int s;
        private final int e;

        public Meeting(int s, int e) {
            this.s = s;
            this.e = e;
        }

        public int getS() {
            return s;
        }

        public int getE() {
            return e;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.e > o.e) {
                return 1;
            } else if (this.e < o.e) {
                return -1;
            } else {
                return Integer.compare(this.s, o.s);
            }
        }
    }
}
