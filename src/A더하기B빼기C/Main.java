package A더하기B빼기C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        int c = Integer.parseInt(br.readLine());

        System.out.println(
                Integer.parseInt(A) + Integer.parseInt(B) - c
        );

        System.out.println(
                Integer.parseInt(A + B) - c
        );
    }
}
