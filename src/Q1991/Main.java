package Q1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 트리 순회
 */
public class Main {
    private static Map<String, List<String>> tree = new HashMap<>();
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            List<String> nodes = new ArrayList<>();
            nodes.add(s[1]);
            nodes.add(s[2]);
            tree.put(s[0], nodes);
        }
        for (int i = 0; i < 3; i++) {
            visited = new boolean[N];
            search(i, "A");
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private static void search(int i, String start) {
        // preorder
        if (i == 0) {
            preorder(start);
        }
        // inorder
        else if (i == 1) {
            inorder(start);
        }
        // postorder
        else {
            postorder(start);
        }
    }

    private static void preorder(String n) {
        sb.append(n);
        visited[n.charAt(0) - 65] = true;
        List<String> nodes = tree.get(n);
        for (String node : nodes) {
            if (!node.equals(".") && !visited[node.charAt(0) - 65]) {
                preorder(node);
            }
        }
    }

    private static void inorder(String n) {
        List<String> nodes = tree.get(n);
        if (nodes.get(0).equals(".") && nodes.get(1).equals(".")) {
            sb.append(n);
            visited[n.charAt(0) - 65] = true;
            return;
        }

        for (String node : nodes) {
            if (!node.equals(".") && !visited[node.charAt(0) - 65]) {
                inorder(node);
            }
            if (!visited[n.charAt(0) - 65]) {
                sb.append(n);
                visited[n.charAt(0) - 65] = true;
            }
        }
    }

    private static void postorder(String n) {
        List<String> nodes = tree.get(n);
        if (nodes.get(0).equals(".") && nodes.get(1).equals(".")) {
            sb.append(n);
            visited[n.charAt(0) - 65] = true;
            return;
        }

        for (String node : nodes) {
            if (!node.equals(".") && !visited[node.charAt(0) - 65]) {
                postorder(node);
            }
        }
        if (!visited[n.charAt(0) - 65]) {
            sb.append(n);
            visited[n.charAt(0) - 65] = true;
        }
    }
}
