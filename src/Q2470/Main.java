package Q2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 두 용액
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] solutions = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(solutions);
        int l = 0, r = N - 1, ans_l = 0, ans_r = N - 1, sum = Integer.MAX_VALUE;
        while (l < r) {
            int n1 = solutions[l];
            int n2 = solutions[r];
            int tmp = n1 + n2;

            if (Math.abs(sum) > Math.abs(tmp)) {
                sum = tmp;
                ans_l = l;
                ans_r = r;
            }

            if (tmp < 0) {
                l++;
            } else if (tmp > 0) {
                r--;
            } else {
                break;
            }
        }
        System.out.println(solutions[ans_l] + " " + solutions[ans_r]);
    }
}
