package P42892;

import java.util.Arrays;
import java.util.Stack;

/**
 * 길 찾기 게임
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(new int[][]{{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}})));
    }

    public static int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];

        Node[] nodes = new Node[nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1], null, null);
        }

        Arrays.sort(nodes);

        Node root = nodes[0];
        for (int i = 1; i < nodes.length; i++) {
            int x = nodes[i].x;
            int y = nodes[i].y;
            Node node = root;
            while (true) {
                if (node.x > x) {
                    if (node.left == null) {
                        node.left = new Node(nodes[i].v, x, y, null, null);
                        break;
                    }
                    node = node.left;
                } else {
                    if (node.right == null) {
                        node.right = new Node(nodes[i].v, x, y, null, null);
                        break;
                    }
                    node = node.right;
                }
            }
        }

        Stack<Node> preorder = new Stack<>();
        preorder.push(root);
        int i = 0;

        while (!preorder.isEmpty()) {
            Node node = preorder.pop();
            answer[0][i++] = node.v;

            if (node.right != null) preorder.push(node.right);
            if (node.left != null) preorder.push(node.left);
        }

        Stack<Node> postorder = new Stack<>();
        postorder.push(root);
        int j = nodeinfo.length - 1;

        while (!postorder.isEmpty()) {
            Node node = postorder.pop();
            answer[1][j--] = node.v;

            if (node.left != null) postorder.push(node.left);
            if (node.right != null) postorder.push(node.right);
        }

        return answer;
    }

    private static class Node implements Comparable<Node> {
        int v, x, y;
        Node left;
        Node right;

        public Node(int v, int x, int y, Node left, Node right) {
            this.v = v;
            this.x = x;
            this.y = y;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Node o) {
            if (this.y != o.y) return Integer.compare(o.y, this.y);
            return Integer.compare(this.x, o.x);
        }
    }
}
