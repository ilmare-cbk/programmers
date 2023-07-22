package 콜라츠추측;

/**
 * 1-1. 입력된 수가 짝수라면 2로 나눕니다.
 * 1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
 * 2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다.
 */
public class Solution {
    public int solution(int num) {
        int answer = 0;
        long number = num;
        if (num == 1) {
            return answer;
        }
        while (answer < 500) {
            if (number % 2 == 0) {
                number = number / 2;
            } else {
                number = (number * 3) + 1;
            }
            answer++;

            if (number == 1) {
                break;
            }
        }

        return answer == 500 ? -1 : answer;
    }

    public static void main(String[] args) {
        int num = 626331;
        Solution solution = new Solution();
        int answer = solution.solution(num);

        System.out.println(answer);
    }
}
