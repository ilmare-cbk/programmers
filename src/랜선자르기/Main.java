package 랜선자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int K = Integer.parseInt(nums[0]);
        int N = Integer.parseInt(nums[1]);
        int[] numbers = new int[K];
        long min = 1;
        long max = Long.MIN_VALUE;
        for (int i = 0; i < K; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, numbers[i]);
        }
        while (Math.abs(min - max) > 1) {
            long mid = (min + max) / 2;
            long sum = 0;
            for (int i = 0; i < K; i++) {
                sum += numbers[i] / mid;
            }
            if (sum >= N) {
                min = mid;
            } else {
                max = mid;
            }
        }
        long sum1 = 0;
        long sum2 = 0;
        for (int i = 0; i < K; i++) {
            sum1 += numbers[i] / min;
            sum2 += numbers[i] / max;
        }
        if (sum1 >= N && sum2 >= N) {
            System.out.println(max);
        } else {
            System.out.println(min);
        }
    }
}
