package 네수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] number = input.split(" ");
        System.out.println(Long.parseLong(number[0] + number[1]) + Long.parseLong(number[2] + number[3]));
    }
}
