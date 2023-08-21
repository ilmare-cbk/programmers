package 약수의개수와덧셈;

public class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            if (findCount(i) % 2 == 0) {
                answer += i;
            }
            else {
                answer -= i;
            }
        }
        return answer;
    }

    /**
     * 약수 갯수 찾기
     */
    private int findCount(int number) {
        int count = 0;
        for (int i = 1; i * i <= number; i++) {
            if (number % i == 0) {
                if (i * i == number) {
                    count++;
                }
                else {
                    count += 2;
                }
            }
        }

        return count;
    }
}
