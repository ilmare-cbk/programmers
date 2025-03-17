package Q5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 이진 검색 트리
 */
public class Main {
    private static Node root = null;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null && !line.isEmpty()) {
            int n = Integer.parseInt(line);
            if (root == null) {
                root = new Node(n);
            } else {
                makeTree(n, root);
            }
        }
        postorder(root);
        System.out.println(sb);
    }

    private static void makeTree(int n, Node node) {
        if (node.n > n) {
            if (node.left == null) {
                node.left = new Node(n);
            } else {
                makeTree(n, node.left);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(n);
            } else {
                makeTree(n, node.right);
            }
        }
    }

    private static void postorder(Node node) {
        if (node.left != null) {
            postorder(node.left);
        }
        if (node.right != null) {
            postorder(node.right);
        }
        sb.append(node.n).append(System.lineSeparator());
    }

    private static class Node {
        int n;
        Node left;
        Node right;

        public Node(int n) {
            this.n = n;
        }
    }
}

