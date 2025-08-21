package P42895;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * N으로 표현
 */
public class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;

        List<Set<Long>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        long concat = 0L;
        for (int i = 1; i <= 8; i++) {
            concat = concat * 10 + N;
            dp.get(i).add(concat);
        }

        for (int depth = 2; depth <= 8; depth++) {
            for (int j = 1; j < depth; j++) {
                for (long a : dp.get(j)) {
                    for (long b : dp.get(depth - j)) {
                        dp.get(depth).add(a + b);
                        dp.get(depth).add(a * b);
                        dp.get(depth).add(a - b);
                        dp.get(depth).add(b - a);

                        if (b != 0 && a % b == 0) dp.get(depth).add(a / b);
                        if (a != 0 && b % a == 0) dp.get(depth).add(b / a);
                    }
                }
            }

            if (dp.get(depth).contains((long)number)) return depth;
        }

        return -1;
    }
}
