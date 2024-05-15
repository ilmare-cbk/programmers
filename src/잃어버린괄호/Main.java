package 잃어버린괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] split = str.split("-");
        int sum = sum(split[0]);
        for (int i = 1; i < split.length; i++) {
            sum -= sum(split[i]);
        }
        System.out.println(sum);
    }

    private static int sum(String split) {
        int sum = 0;
        String[] plus = split.split("\\+");
        for (String s : plus) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }
}
