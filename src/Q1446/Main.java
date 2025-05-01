package Q1446;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 지름길
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        Route[] routes = new Route[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            routes[i] = new Route(s, e, d);
        }
        Arrays.sort(routes);

        int[] dp = new int[D + 1];
        for (int i = 1; i <= D; i++) {
            dp[i] = dp[i - 1] + 1;
        }
        for (int i = 0; i < N; i++) {
            Route route = routes[i];
            int s = route.s;
            int e = route.e;
            int d = route.d;
            for (int j = 1; j <= D; j++) {
                if (j == e) {
                    dp[j] = Math.min(dp[j], dp[s] + d);
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1] + 1);
                }
            }
        }

        System.out.println(dp[D]);
    }

    private static class Route implements Comparable<Route> {
        int s;
        int e;
        int d;

        public Route(int s, int e, int d) {
            this.s = s;
            this.e = e;
            this.d = d;
        }

        @Override
        public int compareTo(Route o) {
            return this.e - o.e;
        }
    }
}
