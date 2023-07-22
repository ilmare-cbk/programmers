package 정수제곱근판별;

public class Solution {
    public long solution(long n) {
        long answer = -1;

//        for (int i = 1; (long) i * i <= n; i++) {
//            if ((long) i * i == n) {
//                answer = (long) (i + 1) * (i + 1);
//            }
//        }

        if (Math.pow((int) Math.sqrt(n), 2) == n) {
            answer = (long) Math.pow(Math.sqrt(n) + 1, 2);
        }

        return answer;
    }

    public static void main(String[] args) {
        double sqrt = Math.sqrt(3);
        System.out.println(sqrt);
    }
}
