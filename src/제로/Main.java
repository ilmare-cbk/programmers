package 제로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number == 0) {
                nums.remove(nums.size() - 1);
            }
            else {
                nums.add(number);
            }
        }
        int answer = 0;
        for (int num : nums) {
            answer += num;
        }
        System.out.println(answer);
    }
}
