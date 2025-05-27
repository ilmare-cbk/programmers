package Q1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 카드 정렬하기
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        while (queue.size() > 1) {
            int n1 = queue.poll();
            int n2 = queue.poll();
            answer += (n1 + n2);
            queue.add(n1 + n2);
        }

        System.out.println(answer);
    }
}
