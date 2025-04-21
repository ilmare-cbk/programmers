package Q2491;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 수열
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max1 = 1;
        int count = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i] >= arr[i - 1]) {
                count++;
            } else {
                max1 = Math.max(max1, count);
                count = 1;
            }
        }
        max1 = Math.max(max1, count);

        int max2 = 1;
        count = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i] <= arr[i - 1]) {
                count++;
            } else {
                max2 = Math.max(max2, count);
                count = 1;
            }
        }
        max2 = Math.max(max2, count);

        System.out.println(Math.max(max1, max2));
    }
}
