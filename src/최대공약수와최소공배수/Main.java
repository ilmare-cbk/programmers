package 최대공약수와최소공배수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        Integer n1 = Integer.parseInt(nums[0]);
        Integer n2 = Integer.parseInt(nums[1]);
        System.out.println(gcd(n1, n2) + System.lineSeparator() + lcm(n1, n2));
    }

    private static int gcd(Integer n1, Integer n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }

    private static int lcm(Integer n1, Integer n2) {
        return (n1 * n2) / gcd(n1, n2);
    }
}
