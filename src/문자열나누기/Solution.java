package 문자열나누기;

public class Solution {
    public int solution(String s) {
        int answer = 0;
        int stackCount = 0;
        char start = s.charAt(0);

        for (int i = 0; i < s.length(); i++) {
            start = init(s, stackCount, start, i);

            if (start == s.charAt(i)) {
                stackCount++;
            } else {
                stackCount--;
            }

            if (stackCount == 0) {
                answer++;
            }
        }

        return stackCount != 0 ? answer + 1 : answer;
    }

    private char init(String s, int stackCount, char start, int i) {
        if (stackCount == 0) {
            start = s.charAt(i);
        }
        return start;
    }

    public static void main(String[] args) {
        String s = "abracadabra";
        Solution solution = new Solution();
        int answer = solution.solution(s);

        System.out.println(answer);
    }
}
