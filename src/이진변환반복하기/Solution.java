package 이진변환반복하기;

import java.util.Arrays;

public class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        StringBuilder sb = new StringBuilder();
        while (!s.equals("1")) {
            int zeroCount = (int) s.chars().filter(it -> ((char) it) == '0').count();
            answer[0]++;
            answer[1] += zeroCount;
            s = convertBinary(s.length() - zeroCount, sb);
            sb.setLength(0);
        }
        return answer;
    }

    private String convertBinary(int reminder, StringBuilder sb) {
        while (reminder / 2 != 0) {
            sb.append(reminder % 2);
            reminder = reminder / 2;
        }
        sb.append(1);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "110010101001";
        Solution solution = new Solution();
        int[] answer = solution.solution(s);

        System.out.println(Arrays.toString(Arrays.stream(answer).toArray()));
    }
}
