package 올바른괄호;

public class Solution {
    boolean solution(String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            sum = stack(s, sum, i);

            if (sum < 0) {
                return false;
            }
        }

        return sum == 0;
    }

    private int stack(String s, int sum, int i) {
        if (s.charAt(i) == '(') {
            sum += 1;
        } else {
            sum -= 1;
        }
        return sum;
    }

}
