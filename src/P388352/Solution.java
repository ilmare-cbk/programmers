package P388352;

/**
 * 비밀 코드 해독
 */
public class Solution {
    private static boolean[][] qCheck;

    public int solution(int n, int[][] q, int[] ans) {
        qCheck = new boolean[q.length][n + 1];
        for (int i = 0; i < q.length; i++) {
            for (int num : q[i]) {
                qCheck[i][num] = true;
            }
        }
        return dfs(n, 1, 0, new int[5], q, ans);
    }

    private int dfs(int n, int idx, int depth, int[] code, int[][] q, int[] ans) {
        if (depth == 5) {
            if (isValid(code, q, ans)) {
                return 1;
            }
            return 0;
        }

        int count = 0;
        for (int i = idx; i <= n; i++) {
            code[depth] = i;
            count += dfs(n, i + 1, depth + 1, code, q, ans);
        }
        return count;
    }

    private boolean isValid(int[] code, int[][] q, int[] ans) {
        for (int t = 0; t < q.length; t++) {
            int cnt = 0; // 코드 위치 별 일치 횟수
            for (int i : code) {
                if (qCheck[t][i]) cnt++;
            }
            if (cnt != ans[t]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(
                solution.solution(10,
                        new int[][]{
                                {1, 2, 3, 4, 5},
                                {6, 7, 8, 9, 10},
                                {3, 7, 8, 9, 10},
                                {2, 5, 7, 9, 10},
                                {3, 4, 5, 6, 7}
                        }, new int[]{2, 3, 4, 3, 3})
        );
    }
}
