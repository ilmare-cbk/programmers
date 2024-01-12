package 스티커;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int arr[][] = new int[2][n];
            String[] l1 = br.readLine().split(" ");
            String[] l2 = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    arr[0][i] = Integer.parseInt(l1[i]);
                    arr[1][i] = Integer.parseInt(l2[i]);
                } else if (i == 1) {
                    arr[0][i] = Integer.parseInt(l1[i]) + arr[1][i - 1];
                    arr[1][i] = Integer.parseInt(l2[i]) + arr[0][i - 1];
                } else {
                    int prevMax = Math.max(arr[0][i - 2], arr[1][i - 2]);
                    arr[0][i] = Integer.parseInt(l1[i]) + Math.max(arr[1][i-1], prevMax);
                    arr[1][i] = Integer.parseInt(l2[i]) + Math.max(arr[0][i-1], prevMax);
                }
            }
            sb.append(Math.max(arr[0][n-1], arr[1][n-1])).append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
