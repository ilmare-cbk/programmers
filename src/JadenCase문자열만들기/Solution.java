package JadenCase문자열만들기;

public class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int[] chars = s.chars().toArray();
        for (int i = 0; i < chars.length; i++) {
            if ((i == 0 && chars[i] >= 97 && chars[i] <= 122) || (i != 0 && chars[i - 1] == 32 && chars[i] >= 97 && chars[i] <= 122)) {
                sb.append((char) (chars[i] - 32));
            } else if (i != 0 && chars[i - 1] != 32 && chars[i] >= 65 && chars[i] <= 90) {
                sb.append((char) (chars[i] + 32));
            } else {
                sb.append((char) chars[i]);
            }
        }
        answer = sb.toString();
        return answer;
    }
}
