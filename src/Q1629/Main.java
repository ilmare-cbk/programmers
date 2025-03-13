package Q1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 곱셈
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int C = Integer.parseInt(input[2]);
        System.out.println(pow(A, B, C));
    }

    private static long pow(int A, int exponent, int C) {
        if (exponent == 1) {
            return A % C;
        }

        long temp = pow(A, exponent / 2, C);

        if (exponent % 2 == 1) {
            return (temp * temp % C) * A % C;
        }
        return temp * temp % C;
    }
}
