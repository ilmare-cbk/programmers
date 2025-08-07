package P42577;

import java.util.Arrays;

/**
 * 전화번호 목록
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(
                solution(new String[]{"119", "97674223", "1195524421", "120", "12", "11"})
        );
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            String cur = phone_book[i];
            String next = phone_book[i + 1];
            if (cur.length() < next.length() && next.startsWith(cur)) {
                return false;
            }
        }
        return answer;
    }
}
