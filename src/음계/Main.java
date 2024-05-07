package 음계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] nums = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        boolean a = true;
        boolean d = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                d = false;
            } else if (nums[i - 1] - 1 == nums[i]) {
                a = false;
            } else {
                a = false;
                d = false;
            }
        }
        System.out.println(a ? "ascending" : d ? "descending" : "mixed");
    }
}
