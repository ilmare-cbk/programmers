package 피로도;

public class Solution {
    private int answer = -1;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited, 0);
        return answer;
    }

    private void dfs(int k, int[][] dungeons, boolean[] visited, int count) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, visited, count + 1);
                visited[i] = false;
            }
        }

        if (answer < count) {
            answer = count;
        }
    }


    public static void main(String[] args) {
//        int k = 100;
//        int[][] dungeons = new int[][]{{100, 1}, {99, 1}, {99, 1}, {99, 1}, {99, 1}, {99, 1}, {99, 1}};

        int k = 80;
        int[][] dungeons = new int[][]{{80, 20}, {50, 40}, {30, 10}};

        Solution solution = new Solution();
        int answer = solution.solution(k, dungeons);

        System.out.println(answer);
    }
}
