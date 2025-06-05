package Q34009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Bob부 멍충이
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        String answer = "Alice";
        if (N % 2 == 1) {
            answer = "Bob";
        } else {
            long aliceSum = 0;
            long bobSum = 0;
            for (int i = N - 1; i >= 0; i--) {
                if (i % 2 == 1) {
                    aliceSum += nums[i];
                } else {
                    bobSum += nums[i];
                }

                if (bobSum >= aliceSum) {
                    answer = "Bob";
                    break;
                }
            }
        }
        System.out.println(answer);


    }
}
