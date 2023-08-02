package 예상대진표;

public class Solution {
    public int solution(int n, int a, int b) {
        int answer = 1;

        while (!isMatched(a, b)) {
            a = findGroupNumber(a);
            b = findGroupNumber(b);
            answer++;
        }

        return answer;
    }

    public int findGroupNumber(int number) {
        if (number % 2 == 0) {
            return number / 2;
        }
        return (number + 1) / 2;
    }

    public boolean isMatched(int number1, int number2) {
        int min = Math.min(number1, number2);
        int max = Math.max(number1, number2);
        return min % 2 != 0 && min + 1 == max;
    }

    public static void main(String[] args) {
        int n = 8;
        int a = 2;
        int b = 3;

        Solution solution = new Solution();
        int answer = solution.solution(n, a, b);

        System.out.println(answer);
    }
}
