package 벌집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 1;
        int last = 1;
        while (true) {
            if (N == 1) {
                break;
            }
            if (last + 1 <= N && N <= last + 6 * count) {
                count++;
                break;
            }
            last = last + 6 * count;
            count++;
        }
        System.out.println(count);
    }
}
