package 게임맵최단거리;

public class Solution {
    private int answer = -1;

    public int solution(int[][] maps) {
        boolean[][] checked = new boolean[maps.length][maps[0].length];
        dfs(0, 0, maps, checked, 1);
        return answer;
    }

    private void dfs(int y, int x, int[][] maps, boolean[][] checked, int move) {
        if (isArrived(y, x, maps)) {
            if (answer == -1 || answer > move) {
                answer = move;
            }
            return;
        }

        checked[y][x] = true;
        if (validate(y - 1, x, maps) && !checked[y - 1][x]) {
            dfs(y - 1, x, maps, checked, move + 1);
        }
        if (validate(y + 1, x, maps) && !checked[y + 1][x]) {
            dfs(y + 1, x, maps, checked, move + 1);
        }
        if (validate(y, x - 1, maps) && !checked[y][x - 1]) {
            dfs(y, x - 1, maps, checked, move + 1);
        }
        if (validate(y, x + 1, maps) && !checked[y][x + 1]) {
            dfs(y, x + 1, maps, checked, move + 1);
        }
        checked[y][x] = false;
    }

    private boolean validate(int y, int x, int[][] maps) {
        return (x >= 0 && x < maps[0].length && y >= 0 && y < maps.length) && maps[y][x] == 1;
    }

    private boolean isArrived(int y, int x, int[][] maps) {
        return y == maps.length - 1 && x == maps[0].length - 1;
    }

    public static void main(String[] args) {
        int[][] maps = new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        Solution solution = new Solution();
        int answer = solution.solution(maps);
        System.out.println(answer);
    }
}
