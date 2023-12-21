package m1.m1_1;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] answers = solution.solution("0123");
        System.out.println(Arrays.toString(Arrays.stream(answers).toArray()));
    }
    public String[] solution(String Phone) {
        String[] line1 = {"01", "10", "10", "11", "11", "10", "11", "11", "10", "01"};
        String[] line2 = {"11", "00", "10", "00", "01", "01", "10", "11", "11", "10"};
        String[] line3 = {"00", "00", "00", "00", "00", "00", "00", "00", "00", "00"};
        int[] numbers = Arrays.stream(Phone.split("")).mapToInt(Integer::parseInt).toArray();
        String l1 = "";
        String l2 = "";
        String l3 = "";
        for (int number : numbers) {
            l1 = l1.concat(line1[number]);
            l2 = l2.concat(line2[number]);
            l3 = l3.concat(line3[number]);
        }
        return new String[]{l1, l2, l3};
    }
}
