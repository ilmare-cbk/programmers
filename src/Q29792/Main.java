package Q29792;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 규칙적인 보스돌이
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 보유한 캐릭터의 개수
        int M = Integer.parseInt(st.nextToken()); // 하루에 사용할 캐릭터의 개수
        int K = Integer.parseInt(st.nextToken()); // 보스의 가짓수
        PriorityQueue<Long> damage = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            damage.offer(Long.parseLong(br.readLine()));
        }
        long[] hp = new long[K];
        int[] meso = new int[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            hp[i] = Long.parseLong(st.nextToken());
            meso[i] = Integer.parseInt(st.nextToken());
        }
        long maxMeso = 0;
        while (M-- > 0 && !damage.isEmpty()) {
            Long d = damage.poll();
            int[] dp = new int[901]; // 해당 초에서 얻을 수 있는 최대 메소
            for (int i = 0; i < K; i++) {
                double killTime = Math.ceil((double) hp[i] / d);
                for (int j = 900; j * d >= hp[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[(int) (j - killTime)] + meso[i]);
                }
            }
            maxMeso += dp[900];
        }
        System.out.println(maxMeso);
    }
}
