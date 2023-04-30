package Q3.step2;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    private int usingWordCount = 0;
    private int endOfStartLetter = 0;
    private int startOfStartLetter = 0;
    private int edgeCount = 0;

    private static final String[] IMPOSSIBLE = new String[]{"impossible"};

    public String[] solution(int N, String[] W) {
        int[] inDegree = new int[26];
        int[] outDegree = new int[26];
        int[][] edges = new int[26][26];
        int[][] searchEdges = new int[26][26];
        makeGraph(W, inDegree, outDegree, edges, searchEdges);
        return wordChaining(N, W, inDegree, outDegree, edges, searchEdges);
    }

    private String[] wordChaining(int N, String[] W, int[] inDegree, int[] outDegree, int[][] edges, int[][] searchEdges) {

        String euler = isEuler(inDegree, outDegree, searchEdges, W);
        if (euler.equals("no")) {
            return IMPOSSIBLE;
        }

        if (euler.equals("circuit")) {
            return Arrays.stream(W)
                    .sorted(Comparator.comparing(it -> it))
                    .toArray(String[]::new);
        }

        if (euler.equals("trail")) {
            for (int i = 0; i < 26; i++) {
                if (outDegree[i] == inDegree[i] + 1) {
                    startOfStartLetter = i;
                    countUsingWord(edges, i, true, N);
                    break;
                }
            }

            if (usingWordCount == N) {
                return Arrays.stream(W)
                        .filter(it -> it.charAt(0) == startOfStartLetter + 'a' &&
                                it.charAt(it.length() - 1) == endOfStartLetter + 'a')
                        .sorted(Comparator.comparing(it -> it))
                        .toArray(String[]::new);
            }
        }

        return IMPOSSIBLE;
    }

    private void countUsingWord(int[][] edges, int i, boolean start, int N) {
        for (int j = 0; j < 26; j++) {
            if (N == usingWordCount) {
                return;
            }
            while (edges[i][j] > 0) {
                if (start) {
                    endOfStartLetter = j;
                }
                edges[i][j]--;
                usingWordCount++;
                countUsingWord(edges, j, false, N);
            }
        }
    }

    private String isEuler(int[] inDegree, int[] outDegree, int[][] edges, String[] W) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < 26; i++) {
            int out = outDegree[i];
            int in = inDegree[i];

            if (out == 0 && in == 0) {
                continue;
            }

            int difference = out - in;
            if (Math.abs(difference) > 1) {
                return "no";
            }
            if (difference == 1) {
                start++;
            }
            if (difference == -1) {
                end++;
            }
        }

        if (start == 1 && end == 1) {
            for (int j = 0; j < 26; j++) {
                if (outDegree[j] == inDegree[j] + 1) {
                    search(edges, j);
                    if (edgeCount != 0) {
                        return "no";
                    }
                    break;
                }
            }
            return "trail";
        }

        if (start == 0 && end == 0) {
            search(edges, W[0].charAt(0) - 'a');
            if (edgeCount != 0) {
                return "no";
            }
            return "circuit";
        }

        return "no";
    }

    private void search(int[][] edges, int i) {
        for (int j = 0; j < edges.length; j++) {
            if (edges[i][j] != 0) {
                edges[i][j]--;
                edgeCount--;
                search(edges, j);
            }
        }
    }

    private void makeGraph(String[] W, int[] inDegree, int[] outDegree, int[][] edges, int[][] searchEdges) {
        for (String s : W) {
            int start = s.charAt(0) - 'a';
            int end = s.charAt(s.length() - 1) - 'a';
            outDegree[start]++;
            inDegree[end]++;
            edges[start][end]++;
            searchEdges[start][end]++;
            edgeCount++;
        }
    }

    public static void main(String[] args) {
        int N = 2;
        String[] W = new String[]{"a", "ab"};
        Solution solution = new Solution();
        String[] answers = solution.solution(N, W);

        System.out.println(Arrays.toString(Arrays.stream(answers).toArray()));
    }
}
