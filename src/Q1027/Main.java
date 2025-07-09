package Q1027;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 고층 건물
 */
public class Main {
    private static int[] buildings;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        buildings = new int[N + 1];
        int[] count = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (check(i, j)) {
                    count[i]++;
                    count[j]++;
                }
            }

            max = Math.max(max, count[i]);
        }

        System.out.println(max);
    }

    private static boolean check(int i, int j) {
        int distance = j - i;
        int height = buildings[j] - buildings[i];
        double a = (double) height / distance; // 기울기

        for (int k = i + 1; k <= j - 1; k++) {
            double a2 = (double) (buildings[k] - buildings[i]) / (k - i);
            if (a2 >= a) return false;
        }
        return true;
    }
}
