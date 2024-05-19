package 최대힙;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        while (N > 0) {
            String command = br.readLine();
            if (command.equals("0")) {
                if (queue.isEmpty()) {
                    bw.write("0" + System.lineSeparator());
                } else {
                    bw.write(queue.poll() + System.lineSeparator());
                }
            } else {
                queue.add(Integer.parseInt(command));
            }
            N--;
        }
        bw.flush();
        bw.close();
    }
}
