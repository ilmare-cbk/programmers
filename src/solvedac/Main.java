package solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(scores);
        int exclude = Math.round((float) (n * 0.15));
        int sum = 0;
        for (int i = exclude; i < n - exclude; i++) {
            sum += scores[i];
        }
        System.out.println(Math.round(((double) sum) / ((double) (n - 2 * exclude))));
    }
}
