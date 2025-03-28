package Q15681;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 트리와 쿼리
 */
public class Main {
    private static int N, R, Q;
    private static List<Integer>[] connect;
    private static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        connect = new List[N + 1];
        size = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            connect[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st1.nextToken());
            int v = Integer.parseInt(st1.nextToken());
            connect[u].add(v);
            connect[v].add(u);
        }

        Node root = new Node(R);
        makeTree(root, -1);
        countSubtreeNodes(root);

        StringBuilder sb = new StringBuilder();
        while (Q-- > 0) {
            sb.append(size[Integer.parseInt(br.readLine())]).append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private static void makeTree(Node currentNode, int parent) {
        for (Integer n : connect[currentNode.value]) {
            if (n != parent) {
                Node node = new Node(n);
                currentNode.children.add(node);
                node.parent = currentNode;
                makeTree(node, currentNode.value);
            }
        }
    }

    private static void countSubtreeNodes(Node currentNode) {
        size[currentNode.value] = 1;
        for (Node node : currentNode.children) {
            countSubtreeNodes(node);
            size[currentNode.value] += size[node.value];
        }
    }


    private static class Node {
        Node parent;
        int value;
        List<Node> children;

        public Node(int value) {
            this.value = value;
            this.children = new ArrayList<>();
        }
    }
}
