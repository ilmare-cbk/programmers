package Q27172;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 수 나누기 게임
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int[] score = new int[N];
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            max = Math.max(nums[i], max);
        }
        int[] index = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            index[nums[i]] = i + 1;
        }
        for (int num : nums) {
            for (int i = num * 2; i <= max; i += num) {
                if (index[i] != 0) {
                    score[index[i] - 1]--;
                    score[index[num] - 1]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int s : score) {
            sb.append(s).append(" ");
        }
        System.out.println(sb);
    }
}