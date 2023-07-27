package 다음큰숫자;

public class Solution {
    public int solution(int n) {
        int answer = n;
        int length = Integer.bitCount(n);
        while (true) {
            int count = Integer.bitCount(++answer);
            if (length == count) {
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 78;
        Solution solution = new Solution();
        int answer = solution.solution(n);

        System.out.println(answer);
    }
}
