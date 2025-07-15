package Q1034;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 램프
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> patternCount = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String lampRow = br.readLine();
            patternCount.put(lampRow, patternCount.getOrDefault(lampRow, 0) + 1);
        }
        int K = Integer.parseInt(br.readLine());

        int max = 0;
        for (Map.Entry<String, Integer> entry : patternCount.entrySet()) {
            String pattern = entry.getKey();
            Integer count = entry.getValue();

            int zeroCount = 0;
            for (char c : pattern.toCharArray()) {
                if (c == '0') zeroCount++;
            }

            if (zeroCount <= K && (K - zeroCount) % 2 == 0) {
                max = Math.max(max, count);
            }
        }

        System.out.println(max);
    }
}
