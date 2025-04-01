package Q2239;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 스도쿠
 */
public class Main {
    private static int[][] sudoku = new int[9][9];
    private static boolean finished = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < row.length; j++) {
                sudoku[i][j] = Integer.parseInt(row[j]);
            }
        }

        dfs(0, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(sudoku[i][j]);
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private static void dfs(int r, int c) {
        if (r == 9) finished = true;
        if (finished) return;

        if (sudoku[r][c] != 0) {
            int[] move = move(r, c);
            dfs(move[0], move[1]);
        } else {
            for (int i = 1; i <= 9; i++) {
                if (possible(r, c, i)) {
                    sudoku[r][c] = i;
                    int[] move = move(r, c);
                    dfs(move[0], move[1]);
                }
            }
            if (!finished) {
                sudoku[r][c] = 0;
            }
        }
    }

    private static int[] move(int r, int c) {
        return c < 8 ? new int[]{r, c + 1} : new int[]{r + 1, 0};
    }

    private static boolean possible(int r, int c, int candidate) {
        int r1 = (r / 3) * 3;
        int c1 = (c / 3) * 3;
        boolean result = true;
        for (int i = 0; i < 9; i++) {
            if (sudoku[r][i] == candidate) result = false;
            if (sudoku[i][c] == candidate) result = false;
            if (i / 3 == 0 && sudoku[r1][c1 + i] == candidate) result = false;
            if (i / 3 == 1 && sudoku[r1 + 1][c1 + i - 3] == candidate) result = false;
            if (i / 3 == 2 && sudoku[r1 + 2][c1 + i - 6] == candidate) result = false;
        }
        return result;
    }
}
