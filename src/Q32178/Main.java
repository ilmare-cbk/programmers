package Q32178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 용액 2
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Sum[] sums = new Sum[N + 1];
        sums[0] = new Sum(0, 0);
        StringTokenizer st = new StringTokenizer(br.readLine());
        long sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += Integer.parseInt(st.nextToken());
            sums[i] = new Sum(sum, i);
        }

        Arrays.sort(sums);

        int bestL = 0, bestR = 0;
        long min = Long.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            Sum s1 = sums[i + 1];
            Sum s2 = sums[i];

            long diff = Math.abs(s1.v - s2.v);
            if (diff < Math.abs(min)) {
                if (s1.idx < s2.idx) {
                    min = s2.v - s1.v;
                    bestL = s1.idx + 1;
                    bestR = s2.idx;
                } else {
                    min = s1.v - s2.v;
                    bestL = s2.idx + 1;
                    bestR = s1.idx;
                }
            }
        }
        System.out.println(min);
        System.out.println(bestL + " " + bestR);
    }

    private static class Sum implements Comparable<Sum> {
        long v;
        int idx;

        public Sum(long v, int idx) {
            this.v = v;
            this.idx = idx;
        }

        @Override
        public int compareTo(Sum o) {
            return Long.compare(this.v, o.v);
        }
    }
}
