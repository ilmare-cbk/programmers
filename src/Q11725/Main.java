package Q11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 트리의 부모 찾기
 */
public class Main {
    private static int N;
    private static int[] answers;
    private static boolean[] visited;
    private static Map<Integer, List<Integer>> nodeMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        answers = new int[N + 1];
        for (int i = 0; i < N - 1; i++) {
            String[] numbers = br.readLine().split(" ");
            int i1 = Integer.parseInt(numbers[0]);
            int i2 = Integer.parseInt(numbers[1]);
            List<Integer> nodes = nodeMap.getOrDefault(i1, new ArrayList<>());
            nodes.add(i2);
            nodeMap.put(i1, nodes);
            List<Integer> node2 = nodeMap.getOrDefault(i2, new ArrayList<>());
            node2.add(i1);
            nodeMap.put(i2, node2);
        }

        visited[1] = true;
        search(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(answers[i]).append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private static void search(int n) {
        List<Integer> nodes = nodeMap.get(n);
        for (Integer node : nodes) {
            if (!visited[node]) {
                visited[node] = true;
                answers[node] = n;
                search(node);
            }
        }
    }
}
