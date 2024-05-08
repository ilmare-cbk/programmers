package 영화감독숌;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int devil = 666;
        int i = 1;
        while(N != i) {
            devil++;
            if (String.valueOf(devil).contains("666")) {
                i++;
            }
        }
        System.out.println(devil);
    }
}
