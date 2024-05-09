package 분해합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int R = 0;
        while (N > R) {
            if (N == R + sumDigits(R, 0)) {
                System.out.println(R);
                return;
            }
            R++;
        }
        System.out.println(0);
    }

    private static int sumDigits(int R, int digit) {
        double pow = Math.pow(10, digit);
        double v = R / pow;
        if (v < 9) {
            return (int) v;
        }
        double reminder = (R % (pow * 10)) / pow;
        return (int) (reminder + sumDigits((int) (R - reminder * pow), digit + 1));
    }
}
