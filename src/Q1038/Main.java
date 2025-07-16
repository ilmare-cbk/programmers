package Q1038;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 감소하는 수
 */
public class Main {
    private static List<Long> decreaseNums = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 10; i++) {
            for (int j = i - 1; j <= 9; j++) {
                dfs(i, j, (long) (j * Math.pow(10, i - 1)));
            }
        }

        decreaseNums.sort(Comparator.naturalOrder());

        if (decreaseNums.size() > N) System.out.println(decreaseNums.get(N));
        else System.out.println(-1);
    }

    private static void dfs(int length, int start, long num) {
        if (length == 1) {
            decreaseNums.add(num);
            return;
        }

        for (int i = start - 1; i >= 0; i--) {
            dfs(length - 1, i, (long) (num + i * Math.pow(10, length - 2)));
        }

    }
}
