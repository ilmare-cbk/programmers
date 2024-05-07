package 트리.step3;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    List<TreeNode> nodes = new ArrayList<>();
    int[][] C;
    boolean[] checked;

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answer = solution.solution(6, new int[][]{{1, 2}, {2, 3}, {3, 4}, {3, 5}, {2, 6}}, 1, new int[]{1,1,0,1,1,1});
        System.out.println(Arrays.toString(answer));
    }

    public int[] solution(int N, int[][] C, int T, int[] S) {
        this.C = C;
        this.checked = new boolean[N - 1];

        nodes.add(new TreeNode(T, -1));
        traverse(T);
        Tree tree = Tree.build(nodes);
        tree.turnOff(S);

        List<TreeNode> nodes = tree.getNodes();
        int[] answer = new int[nodes.size()];

        for (int i = 1; i <= nodes.size(); i++) {
            answer[i - 1] = nodes.get(i - 1).getId();
        }
        return answer;
    }

    private void traverse(int node) {
        for (int i = 0; i < C.length; i++) {
            if (checked[i]) {
                continue;
            }

            if (C[i][0] == node) {
                nodes.add(new TreeNode(C[i][1], node));
                checked[i] = true;
                traverse(C[i][1]);
            }

            if (C[i][1] == node) {
                nodes.add(new TreeNode(C[i][0], node));
                checked[i] = true;
                traverse(C[i][0]);
            }
        }
    }

    private static class TreeNode {
        private int id;
        private int parentId;
        private List<TreeNode> childNodes;
        private boolean turnOn;

        public TreeNode(int id, int parentId) {
            this.id = id;
            this.parentId = parentId;
            this.childNodes = new ArrayList<>();
            this.turnOn = true;
        }

        public int getId() {
            return id;
        }

        public void addChild(TreeNode node) {
            this.childNodes.add(node);
        }

        public boolean isRoot() {
            return this.parentId == -1;
        }

        public void turnOff() {
            this.turnOn = false;
        }

        public void traverse(Function<TreeNode, Void> function) {
            for (TreeNode childNode : childNodes) {
                childNode.traverse(function);
            }
            function.apply(this);
        }
    }

    private static class Tree {
        private TreeNode rootNode;
        private Map<Integer, TreeNode> nodeDict = new HashMap<>();

        public static Tree build(List<TreeNode> nodes) {
            Tree tree = new Tree();
            tree.nodeDict = nodes.stream().collect(Collectors.toMap(TreeNode::getId, Function.identity()));


            for (TreeNode node : nodes) {
                if (node.isRoot()) {
                    tree.rootNode = node;
                    continue;
                }

                TreeNode parent = tree.nodeDict.get(node.parentId);

                if (parent != null) {
                    parent.addChild(node);
                }
            }

            return tree;
        }

        public List<TreeNode> getNodes() {
            return nodeDict.entrySet()
                    .stream()
                    .filter(it -> it.getValue().turnOn)
                    .sorted(Map.Entry.comparingByKey())
                    .map(Map.Entry::getValue)
                    .collect(Collectors.toList());
        }

        public void turnOff(int[] S) {
            for (int i = 0; i < S.length; i++) {
                if (S[i] == 1) {
                    continue;
                }

                TreeNode treeNode = nodeDict.get(i + 1);
                treeNode.traverse(node -> {
                    node.childNodes.forEach(TreeNode::turnOff);
                    return null;
                });
            }
        }
    }
}
