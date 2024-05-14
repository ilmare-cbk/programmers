package 최소힙;

import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        while (N > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (queue.isEmpty()) {
                    bw.write(0 + System.lineSeparator());
                } else {
                    bw.write(queue.poll() + System.lineSeparator());
                }
            } else {
                queue.add(x);
            }
            N--;
        }
        bw.flush();
        bw.close();
    }
}
