package Q1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Z
 */
public class Main {
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int r = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);
        int size = (int) Math.pow(2, N);
        find(r, c, size);
        System.out.println(answer);
    }

    private static void find(int r, int c, int size) {
        if (size == 1) {
            return;
        }

        if (r < size / 2 && c < size / 2) {
            find(r, c, size / 2);
        } else if (r < size / 2 && c >= size / 2) {
            answer += (size * size) / 4;
            find(r, c - size / 2, size / 2);
        } else if (r >= size / 2 && c < size / 2) {
            answer += ((size * size) / 4) * 2;
            find(r - size / 2, c, size / 2);
        } else {
            answer += ((size * size) / 4) * 3;
            find(r - size / 2, c - size / 2, size / 2);
        }
    }
}
