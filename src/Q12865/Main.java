package Q12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 평범한 배낭
 */
public class Main {
    private static int N;
    private static int K;
    private static List<Item> items = new ArrayList<>();
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        dp = new int[K + 1];
        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split(" ");
            items.add(new Item(Integer.parseInt(data[0]), Integer.parseInt(data[1])));
        }
        for (int i = 0; i < N; i++) {
            int weight = items.get(i).w;
            int value = items.get(i).v;
            for (int w = K; w >= weight; w--) { // 뒤에서부터 업데이트
                dp[w] = Math.max(dp[w], dp[w - weight] + value);
            }
        }

        System.out.println(dp[K]); // 최대 가치 출력

    }

    private static class Item {
        int w;
        int v;

        public Item(int w, int v) {
            this.w = w;
            this.v = v;
        }

        public int getW() {
            return w;
        }

        public int getV() {
            return v;
        }
    }
}
