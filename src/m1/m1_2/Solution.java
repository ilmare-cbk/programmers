package m1.m1_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String answer = solution.solution(new String[]{"01101011", "11001000", "00000000"});
        System.out.println(answer);
    }

    public String solution(String[] Braille) {
        StringBuilder sb = new StringBuilder();
        List<String> line1 = Arrays.asList("01", "10", "10", "11", "11", "10", "11", "11", "10", "01");
        List<String> line2 = Arrays.asList("11", "00", "10", "00", "01", "01", "10", "11", "11", "10");
        List<String> line3 = Arrays.asList("00", "00", "00", "00", "00", "00", "00", "00", "00", "00");

        Pattern pattern = Pattern.compile(".{1,2}");

        Matcher matcher1 = pattern.matcher(Braille[0]);
        Matcher matcher2 = pattern.matcher(Braille[1]);
        Matcher matcher3 = pattern.matcher(Braille[2]);
        while (matcher1.find() && matcher2.find() && matcher3.find()) {
            List<Integer> index = findIndex(line1, matcher1.group());
            appendAnswer(sb, line2, matcher2, index);
        }

        return sb.toString();
    }

    private void appendAnswer(StringBuilder sb, List<String> line2, Matcher matcher2, List<Integer> index) {
        for (Integer idx : index) {
            if (line2.get(idx).equals(matcher2.group())) {
                sb.append(idx);
                break;
            }
        }
    }

    private List<Integer> findIndex(List<String> line1, String s) {
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < line1.size(); i++) {
            if (line1.get(i).equals(s)) {
                index.add(i);
            }
        }
        return index;
    }
}
