package Q2467;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 용액
 */
public class Main {
    private static int N;
    private static int[] solution;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        solution = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }

        if (solution[0] > 0) {
            System.out.println(solution[0] + " " + solution[1]);
            return;
        }

        if (solution[N - 1] < 0) {
            System.out.println(solution[N - 2] + " " + solution[N - 1]);
            return;
        }

        int l = 0, r = N - 1;
        int bestL = l, bestR = r;
        int minSum = Integer.MAX_VALUE;

        while (l < r) {
            int currentSum = solution[l] + solution[r];

            if (Math.abs(currentSum) < Math.abs(minSum)) {
                minSum = currentSum;
                bestL = l;
                bestR = r;
                if (currentSum == 0) break;
            }

            if (currentSum > 0) r--;
            else l++;
        }
        System.out.println(solution[bestL] + " " + solution[bestR]);
    }
}
