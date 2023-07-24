package 핸드폰번호가리기;

public class Solution {
    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder();
        String[] numbers = phone_number.split("");
        for (int i = 0; i < numbers.length; i++) {
            if (i < numbers.length - 4) {
                numbers[i] = "*";
            }
            sb.append(numbers[i]);
        }

        return sb.toString();
    }
}
