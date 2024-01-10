package 최대최소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        String[] numbers = bufferedReader.readLine().split(" ");
        for (String number : numbers) {
            int n = Integer.parseInt(number);
            if (n > max) {
                max = n;
            }
            if (n < min) {
                min = n;
            }
        }
        System.out.println(min + " " + max);
    }

}
