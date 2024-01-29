package 국영수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = nextInt(br);
        String[][] score = new String[N][4];
        for (int i = 0; i < N; i++) {
            String[] info = br.readLine().split(" ");
            score[i][0] = info[0];
            score[i][1] = info[1];
            score[i][2] = info[2];
            score[i][3] = info[3];
        }
        Comparator<String[]> c1 = (o1, o2) -> Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
        Comparator<String[]> c2 = Comparator.comparingInt(o -> Integer.parseInt(o[2]));
        Comparator<String[]> c3 = (o1, o2) -> Integer.parseInt(o2[3]) - Integer.parseInt(o1[3]);
        Arrays.sort(score, c1.thenComparing(c2).thenComparing(c3).thenComparing(o -> o[0]));

        StringBuilder sb = new StringBuilder();
        for (String[] m : score) {
            sb.append(m[0]).append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private static int nextInt(BufferedReader br) throws IOException {
        int n = 0;
        while (true) {
            int input = br.read();
            if (input >= '0' && input <= '9') {
                n = (n << 3) + (n << 1) + (input & 15);
            } else {
                return n;
            }
        }
    }
}
