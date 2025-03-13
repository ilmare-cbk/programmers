package Q16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * A → B
 */
public class Main {
    private static long A;
    private static long B;
    private static Map<Long, Integer> count = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        A = Long.parseLong(input[0]);
        B = Long.parseLong(input[1]);
        search(A);
        count.put(A, 0);
        System.out.println(count.getOrDefault(B, -2) + 1);
    }

    private static void search(long n) {
        long n1 = 2 * n;
        if (n1 <= B) {
            count.put(n1, Math.min(count.getOrDefault(n, 0) + 1, count.getOrDefault(n1, Integer.MAX_VALUE)));
            search(n1);
        }

        long n2 = 10 * n + 1;
        if (n2 <= B) {
            count.put(n2, Math.min(count.getOrDefault(n, 0) + 1, count.getOrDefault(n2, Integer.MAX_VALUE)));
            search(n2);
        }
    }
}