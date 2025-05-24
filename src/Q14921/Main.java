package Q14921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 용액 합성하기
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

        int l = 0, r = N - 1;
        int min = Integer.MAX_VALUE;
        while (l < r) {
            int sum = solutions[l] + solutions[r];

            if (Math.abs(sum) < Math.abs(min)) {
                min = sum;
            }

            if (sum < 0) {
                l++;
            } else if (sum > 0) {
                r--;
            } else {
                break;
            }
        }

        System.out.println(min);
    }
}
