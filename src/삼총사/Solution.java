package 삼총사;

import java.util.Arrays;

public class Solution {
    private static int answer = 0;

    public int solution(int[] number) {
        addRecursive(0, 0, number, new int[3]);
        return answer;
    }

    private void addRecursive(int idx, int count, int[] number, int[] selectedNumber) {
        if (count == 3) {
            answer += Arrays.stream(selectedNumber).sum() == 0 ? 1 : 0;
            return;
        }

        for (int i = idx; i < number.length; i++) {
            selectedNumber[count] = number[i];
            addRecursive(i + 1, count + 1, number, selectedNumber);
        }
    }

    public static void main(String[] args) {
        int[] number = new int[]{-3, -2, -1, 0, 1, 2, 3};

        Solution solution = new Solution();
        int answer = solution.solution(number);

        System.out.println(answer);
    }
}
