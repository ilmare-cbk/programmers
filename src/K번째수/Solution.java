package K번째수;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        List<Integer> arrays = Arrays.stream(array).boxed().collect(Collectors.toList());

        for (int i = 0; i < commands.length; i++) {
            answer[i] = arrays.subList(commands[i][0] - 1, commands[i][1])
                    .stream()
                    .sorted()
                    .collect(Collectors.toList())
                    .get(commands[i][2] - 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        Solution solution = new Solution();
        int[] answers = solution.solution(array, commands);

        System.out.println(Arrays.toString(Arrays.stream(answers).toArray()));
    }
}
