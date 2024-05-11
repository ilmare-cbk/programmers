package 달팽이는올라가고싶다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int A = Integer.parseInt(nums[0]);
        int B = Integer.parseInt(nums[1]);
        int V = Integer.parseInt(nums[2]);
        int days = (V - A) / (A - B);
        if ((V - A) % (A - B) != 0) {
            days++;
        }
        System.out.println(days + 1);
    }
}
