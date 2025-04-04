package Q1644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 소수의 연속합
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            return;
        }

        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            for (int j = i * i; j <= N; j += i) {
                if (isPrime[j]) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primeList.add(i);
            }
        }

        int l = 0, r = 0, cnt = 0, sum = 0;
        while (true) {
            if (sum >= N) {
                if (sum == N) cnt++;
                sum -= primeList.get(l++);
            } else {
                if (r == primeList.size()) break;
                sum += primeList.get(r++);
            }
        }
        System.out.println(cnt);
    }
}
