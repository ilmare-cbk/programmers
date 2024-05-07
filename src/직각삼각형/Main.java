package 직각삼각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            List<Integer> nums = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .sorted(Comparator.comparing(it -> it))
                    .collect(Collectors.toList());
            Integer n1 = nums.get(0);
            Integer n2 = nums.get(1);
            Integer n3 = nums.get(2);
            if (n1 + n2 + n3 == 0) {
                return;
            }
            if ((n3 * n3) == (n1 * n1) + (n2 * n2)) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}
