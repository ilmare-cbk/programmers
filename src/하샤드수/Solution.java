package 하샤드수;

public class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int sum = addEachDigit(x);
        if (x % sum != 0) {
            answer = false;
        }
        return answer;
    }

    private int addEachDigit(int x) {
        int quotient = x;
        int r = 0;
        while (quotient != 0) {
            r += quotient % 10;
            quotient = quotient / 10;
        }
        return r;
    }

    public static void main(String[] args) {
        int x = 10;
        Solution solution = new Solution();
        boolean answer = solution.solution(10);

        System.out.println(answer);
    }
}
