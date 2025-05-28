package Q20303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 할로윈의 양아치
 */
public class Main {
    private static int N, M, K;
    private static int[] candy;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        candy = new int[N + 1];
        parent = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            candy[i] = Integer.parseInt(st.nextToken());
            parent[i] = i;
        }
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            union(n1, n2);
        }
        Map<Integer, Group> groupDict = new HashMap<>(); // group by parent
        for (int i = 1; i <= N; i++) {
            int p = find(i);
            Group group = groupDict.getOrDefault(p, new Group(0, 0));
            group.size++;
            group.candy += candy[i];
            groupDict.put(p, group);
        }
        int[] dp = new int[K];
        for (Group g : groupDict.values()) {
            for (int i = K - 1; i >= g.size; i--) {
                dp[i] = Math.max(dp[i], dp[i - g.size] + g.candy);
            }
        }
        System.out.println(dp[K - 1]);
    }

    private static void union(int n1, int n2) {
        int root1 = find(n1);
        int root2 = find(n2);

        if (root1 != root2) {
            parent[root2] = root1;
        }
    }

    private static int find(int n) {
        if (parent[n] != n) {
            parent[n] = find(parent[n]);
        }
        return parent[n];
    }

    private static class Group {
        int size;
        int candy;

        public Group(int size, int candy) {
            this.size = size;
            this.candy = candy;
        }
    }
}
