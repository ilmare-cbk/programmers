package Q1025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 제곱수 찾기
 */
public class Main {
    private static int N, M;
    private static int[][] arr;
    private static Set<Integer> squares = new HashSet<>();
    private static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < 31623; i++) {
            squares.add(i * i);
        }

        for (int i = 0; i < N; i++) {
            String[] nums = br.readLine().split("");
            for (int j = 0; j < nums.length; j++) {
                arr[i][j] = Integer.parseInt(nums[j]);
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                for (int dr = -N + 1; dr < N; dr++) {
                    for (int dc = -M + 1; dc < M; dc++) {
                        cal(r, c, dr, dc);
                    }
                }
            }
        }

        System.out.println(max);
    }

    private static void cal(int r, int c, int dr, int dc) {
        if (dr == 0 && dc == 0) {
            if (squares.contains(arr[r][c])) {
                max = Math.max(max, arr[r][c]);
            }
            return;
        }

        int num = 0;
        while (r >= 0 && r < N && c >= 0 && c < M) {
            num = num * 10 + arr[r][c];
            if (squares.contains(num)) {
                max = Math.max(max, num);
            }
            r += dr;
            c += dc;
        }
    }
}
