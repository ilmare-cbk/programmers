package 팩토리얼0의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count_2 = 0;
        int count_5 = 0;
        for (int i = 1; i <= N; i++) {
            count_2 = getCount_2(count_2, i);
            count_5 = getCount_5(count_5, i);
        }
        System.out.println(Math.min(count_2, count_5));
    }

    private static int getCount_5(int count_5, int i) {
        while (i % 5 == 0) {
            count_5++;
            i = i / 5;
        }
        return count_5;
    }

    private static int getCount_2(int count_2, int i) {
        while (i % 2 == 0) {
            count_2++;
            i = i / 2;
        }
        return count_2;
    }

}
