package 카드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int maxCount = 0;
        long minCard = Long.MAX_VALUE;
        Map<Long, Integer> count = new HashMap<>();
        for (int i = 0; i < N; i++) {
            long n = Long.parseLong(br.readLine());
            int value = count.getOrDefault(n, 0) + 1;
            count.put(n, value);
            if (value > maxCount) {
                maxCount = value;
                minCard = n;
            }
            else if (value == maxCount && n < minCard) {
                minCard = n;
            }
        }
        System.out.println(minCard);
    }
}
