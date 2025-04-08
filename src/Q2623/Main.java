package Q2623;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 음악프로그램
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] degree = new int[N + 1];
        List<Integer>[] graph = new List[N + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int n1 = Integer.parseInt(st.nextToken());
            for (int j = 1; j < cnt; j++) {
                int n2 = Integer.parseInt(st.nextToken());
                graph[n1].add(n2);
                degree[n2]++;
                n1 = n2;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer n = queue.poll();
            result.add(n);

            for (Integer num : graph[n]) {
                degree[num]--;
                if (degree[num] == 0) {
                    queue.add(num);
                }
            }
        }

        if (result.size() != N) {
            System.out.println(0);
        } else {
            StringBuilder sb = new StringBuilder();
            for (Integer i : result) {
                sb.append(i).append(System.lineSeparator());
            }
            System.out.println(sb);
        }
    }
}
