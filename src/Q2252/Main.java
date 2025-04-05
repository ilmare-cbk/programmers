package Q2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 줄 세우기
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] degree = new int[N + 1];
        List<Integer>[] grpah = new List[N + 1];
        for (int i = 0; i < N; i++) {
            grpah[i + 1] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            grpah[n1].add(n2);
            degree[n2]++;
        }

        List<Integer> order = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer student = queue.poll();
            order.add(student);

            for (Integer next : grpah[student]) {
                degree[next]--;
                if (degree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Integer i : order) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}