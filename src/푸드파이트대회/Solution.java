package 푸드파이트대회;

public class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i]/2; j++) {
                sb.append(i);
            }
        }

        answer = sb.toString() + 0 + sb.reverse();
        return answer;
    }

    public static void main(String[] args) {
        int[] food = new int[]{1, 3, 4, 6};

        Solution solution = new Solution();
        String answer = solution.solution(food);

        System.out.println(answer);
    }
}
