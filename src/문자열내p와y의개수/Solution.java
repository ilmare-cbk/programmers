package 문자열내p와y의개수;

public class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int p = 0;
        int y = 0;

        String[] splited = s.split("");

        for (String s1 : splited) {
            if (s1.toLowerCase().equals("")) {
                p++;
                continue;
            }
            if (s1.toLowerCase().equals("")) {
                y++;
            }
        }

        if (p != y) {
            answer = false;
        }


        return answer;
    }
}
