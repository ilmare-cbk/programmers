package Q2473;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 세 용액
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] solution = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(solution);

        int[] answers = new int[3];
        long minSum = Long.MAX_VALUE;

        for (int i = 0; i < N - 2; i++) {
            int l = i + 1, r = N - 1;

            while (l < r) {
                long sum = (long) solution[i] + solution[l] + solution[r];
                if (Math.abs(sum) < Math.abs(minSum)) {
                    minSum = sum;
                    answers[0] = solution[i];
                    answers[1] = solution[l];
                    answers[2] = solution[r];
                }

                if (sum > 0) r--;
                else l++;
            }
        }

        Arrays.sort(answers);
        System.out.println(answers[0] + " " + answers[1] + " " + answers[2]);
    }
}
