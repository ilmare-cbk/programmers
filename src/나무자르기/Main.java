package 나무자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        long max = 0;
        long min = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        long result = 0;
        while (min <= max) {
            long mid = (min + max) / 2;
            long sum = getSum(trees, mid);

            if (sum >= M) {
                result = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }

        }
        System.out.println(result);
    }

    private static long getSum(int[] trees, long mid) {
        long sum = 0;
        for (int tree : trees) {
            if (tree > mid) {
                sum += tree - mid;
            }
        }
        return sum;
    }
}
