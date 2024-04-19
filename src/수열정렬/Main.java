package 수열정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] A = new int[N][2];
        int[] P = new int[N];

        String[] nums = br.readLine().split(" ");

        for (int i = 0; i < nums.length; i++) {
            A[i][0] = Integer.parseInt(nums[i]);
            A[i][1] = i;
        }

        Arrays.sort(A, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);

        for (int i = 0; i < A.length; i++) {
            P[A[i][1]] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : P) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}
