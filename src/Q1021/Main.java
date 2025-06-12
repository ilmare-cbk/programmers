package Q1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 회전하는 큐
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = N; i >= 1; i--) {
            deque.push(i);
        }
        int[] nums = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        for (int num : nums) {
            int index = 0;
            for (Integer i : deque) {
                if (i == num) {
                    break;
                } else {
                    index++;
                }
            }
            if ((deque.size() - 1) / 2 >= index) {
                while (!deque.isEmpty() && deque.peek() != num) {
                    Integer e = deque.pollFirst();
                    deque.addLast(e);
                    cnt++;
                }
            } else {
                while (!deque.isEmpty() && deque.peek() != num) {
                    Integer e = deque.pollLast();
                    deque.addFirst(e);
                    cnt++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(cnt);
    }
}
