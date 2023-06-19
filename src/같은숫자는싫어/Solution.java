package 같은숫자는싫어;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] solution(int[] arr) {
        List<Integer> answers = new ArrayList<>();
        for (int j : arr) {
            if (!answers.isEmpty() && answers.get(answers.size() - 1) == j) {
                continue;
            }
            answers.add(j);
        }

        return answers.stream()
                .mapToInt(it -> it)
                .toArray();
    }

    public static void main(String[] args) {
//        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        int[] arr = {4, 4, 4, 3, 3};

        Solution solution = new Solution();
        int[] answers = solution.solution(arr);

        System.out.println(Arrays.toString(Arrays.stream(answers).toArray()));
    }
}
