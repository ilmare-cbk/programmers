package 블랙잭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static int M;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rules = br.readLine().split(" ");
        int N = Integer.parseInt(rules[0]);
        M = Integer.parseInt(rules[1]);
        List<Integer> nums = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < nums.size() - 2; i++) {
            for (int j = i + 1; j < nums.size() - 1; j++) {
                for (int k = j + 1; k < nums.size(); k++) {
                    blackjack(nums.get(i), nums.get(j), nums.get(k));
                    if (answer == M) {
                        System.out.println(answer);
                        return;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    private static void blackjack(int i, int j, int k) {
        int expected = i + j + k;
        if (expected >= answer && expected <= M) {
            answer = expected;
        }
    }
}
