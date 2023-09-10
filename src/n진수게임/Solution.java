package n진수게임;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public String solution(int n, int t, int m, int p) {
        int number = 0;
        int length = t * m;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        List<String> numbers = createNumbers(n, number, length);

        while (sb.length() < t) {
            sb.append(numbers.get(p + m * i - 1));
            i++;
        }

        return sb.toString();
    }

    private List<String> createNumbers(int n, int number, int length) {
        List<String> numbers = new ArrayList<>();
        while (numbers.size() < length) {
            String[] split = Integer.toString(number, n).split("");
            numbers.addAll(Arrays.stream(split).map(String::toUpperCase).collect(Collectors.toList()));
            number++;
        }

        return numbers;
    }

    public static void main(String[] args) {
        int n = 16;
        int t = 16;
        int m = 2;
        int p = 1;

        Solution solution = new Solution();
        String answer = solution.solution(n, t, m, p);

        System.out.println(answer);
    }
}
