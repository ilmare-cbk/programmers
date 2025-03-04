package 테트로미노;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        int N = Integer.parseInt(data[0]);
        int M = Integer.parseInt(data[1]);
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] nums = br.readLine().split(" ");
            for (int j = 0; j < nums.length; j++) {
                arr[i][j] = Integer.parseInt(nums[j]);
            }
        }

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                max = Math.max(Math.max(Math.max(Math.max(Math.max(max, findT1(i, j, arr)), findT2(i, j, arr)), findT3(i, j, arr)), findT4(i, j, arr)), findT5(i, j, arr));
            }
        }

        System.out.println(max);
    }


    private static int findT1(int i, int j, int[][] arr) {
        int max = 0;
        if (i + 3 < arr.length) {
            max = arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 3][j];
        }

        if (j + 3 < arr[i].length) {
            max = Math.max(
                    max,
                    arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i][j + 3]
            );
        }

        return max;
    }

    private static int findT2(int i, int j, int[][] arr) {
        if (i + 1 < arr.length && j + 1 < arr[i].length) {
            return arr[i][j] + arr[i][j + 1] + arr[i + 1][j] + arr[i + 1][j + 1];
        }
        return 0;
    }

    private static int findT3(int i, int j, int[][] arr) {
        int max = 0;
        if (i + 2 < arr.length && j + 1 < arr[i].length) {
            max = arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 2][j + 1];
        }

        if (i + 2 < arr.length && j - 1 >= 0) {
            max = Math.max(
                    max,
                    arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 2][j - 1]
            );
        }

        if (i + 1 < arr.length && j + 2 < arr[i].length) {
            max = Math.max(
                    max,
                    arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 2]
            );
        }

        if (i - 1 >= 0 && j + 2 < arr[i].length) {
            max = Math.max(
                    max,
                    arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i - 1][j + 2]
            );
        }

        if (i - 2 >= 0 && j + 1 < arr[i].length) {
            max = Math.max(
                    max,
                    arr[i][j] + arr[i - 1][j] + arr[i - 2][j] + arr[i - 2][j + 1]
            );
        }

        if (i - 2 >= 0 && j - 1 >= 0) {
            max = Math.max(
                    max,
                    arr[i][j] + arr[i - 1][j] + arr[i - 2][j] + arr[i - 2][j - 1]
            );
        }

        if (i + 1 < arr.length && j - 2 >= 0) {
            max = Math.max(
                    max,
                    arr[i][j] + arr[i][j - 1] + arr[i][j - 2] + arr[i + 1][j - 2]
            );
        }

        if (i - 1 >= 0 && j - 2 >= 0) {
            max = Math.max(
                    max,
                    arr[i][j] + arr[i][j - 1] + arr[i][j - 2] + arr[i - 1][j - 2]
            );
        }
        return max;
    }

    private static int findT4(int i, int j, int[][] arr) {
        int max = 0;
        if (i + 2 < arr.length && j + 1 < arr[i].length) {
            max = arr[i][j] + arr[i + 1][j] + arr[i + 1][j + 1] + arr[i + 2][j + 1];
        }

        if (i + 2 < arr.length && j - 1 >= 0) {
            max = Math.max(
                    max,
                    arr[i][j] + arr[i + 1][j] + arr[i + 1][j - 1] + arr[i + 2][j - 1]
            );
        }

        if (i - 1 >= 0 && j + 2 < arr[i].length) {
            max = Math.max(
                    max,
                    arr[i][j] + arr[i][j + 1] + arr[i - 1][j + 1] + arr[i - 1][j + 2]
            );
        }

        if (i - 1 >= 0 && j - 2 >= 0) {
            max = Math.max(
                    max,
                    arr[i][j] + arr[i][j - 1] + arr[i - 1][j - 1] + arr[i - 1][j - 2]
            );
        }

        return max;
    }

    private static int findT5(int i, int j, int[][] arr) {
        int max = 0;
        if (i + 1 < arr.length && j + 2 < arr[i].length) {
            max = arr[i][j] + arr[i][j + 1] + arr[i + 1][j + 1] + arr[i][j + 2];
        }

        if (i - 2 >= 0 && j + 1 < arr[i].length) {
            max = Math.max(
                    max,
                    arr[i][j] + arr[i - 1][j] + arr[i - 1][j + 1] + arr[i - 2][j]
            );
        }

        if (i - 1 >= 0 && j - 2 >= 0) {
            max = Math.max(
                    max,
                    arr[i][j] + arr[i][j - 1] + arr[i - 1][j - 1] + arr[i][j - 2]
            );
        }

        if (i + 2 < arr.length && j - 1 >= 0) {
            max = Math.max(
                    max,
                    arr[i][j] + arr[i + 1][j] + arr[i + 1][j - 1] + arr[i + 2][j]
            );
        }

        return max;
    }
}