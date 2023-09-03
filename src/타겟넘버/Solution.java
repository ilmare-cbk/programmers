package 타겟넘버;

public class Solution {
    private int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(0, target, numbers, 0, 0);
        return answer;
    }

    private void dfs(int number, int target, int[] numbers, int step, int idx) {
        if (step == numbers.length) {
            if (number == target) {
                answer++;
            }
            return;
        }

        dfs(number + numbers[idx], target, numbers, step + 1, idx + 1);
        dfs(number - numbers[idx], target, numbers, step + 1, idx + 1);

    }


    public static void main(String[] args) {
        int[] numbers = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        Solution solution = new Solution();
        int answer = solution.solution(numbers, target);

        System.out.println(answer);
    }
}
