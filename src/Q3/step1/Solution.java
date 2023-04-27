package Q3.step1;

public class Solution {
    private int usingWordCount = 0;

    public String solution(int N, String[] W) {
        int[] inDegree = new int[26];
        int[] outDegree = new int[26];
        int[][] edges = new int[26][26];
        makeGraph(W, inDegree, outDegree, edges);
        String answer = wordChaining(N, inDegree, outDegree, edges);
        if (answer.equals("Yes")) {
            return answer;
        }
        return wordChaining2(W);
    }

    private String wordChaining(int N, int[] inDegree, int[] outDegree, int[][] edges) {

        if (!isEuler(inDegree, outDegree)) {
            return "No";
        }

        for (int i = 0; i < 26; i++) {
            if ((outDegree[i] != 0 && outDegree[i] == inDegree[i]) || (outDegree[i] == inDegree[i] + 1)) {
                countUsingWord(edges, i);
                break;
            }
        }

        if (usingWordCount == N) {
            return "Yes";
        }

        return "No";
    }

    private String wordChaining2(String[] W) {
        String answer = "Yes";

        if (W.length == 0) {
            return "No";
        }

        if (W.length == 1) {
            return "Yes";
        }

        for (int i = 0; i < W.length - 1; i++) {
            String end = W[i].substring(W[i].length() - 1);
            String start = W[i + 1].substring(0, 1);
            if (!end.equals(start)) {
                return "No";
            }
        }

        return answer;
    }

    private void countUsingWord(int[][] edges, int i) {
        for (int j = 0; j < 26; j++) {
            while (edges[i][j] > 0) {
                edges[i][j]--;
                usingWordCount++;
                countUsingWord(edges, j);
            }
        }
    }

    private boolean isEuler(int[] inDegree, int[] outDegree) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < 26; i++) {
            int difference = outDegree[i] - inDegree[i];
            if (Math.abs(difference) > 1) {
                return false;
            }
            if (difference == 1) {
                start++;
            }
            if (difference == -1) {
                end++;
            }
        }

        return ((start == 1 && end == 1) || (start == 0 && end == 0));
    }

    private void makeGraph(String[] W, int[] inDegree, int[] outDegree, int[][] edges) {
        for (String s : W) {
            int start = s.charAt(0) - 'a';
            int end = s.charAt(s.length() - 1) - 'a';
            outDegree[start]++;
            inDegree[end]++;
            edges[start][end]++;
        }
    }

    public static void main(String[] args) {
        int N = 2;
        String[] W = new String[]{"a", "a"};
        Solution solution = new Solution();
        String answer = solution.solution(N, W);

        System.out.println(answer);
    }
}
