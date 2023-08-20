package 부족한금액계산하기;

public class Solution {
    public long solution(int price, int money, int count) {
        long total = 0;

        for(int i = 1; i <= count; i++) {
            total += (long) price * i;
        }

        long difference = total - money;

        return difference > 0 ? difference : 0;
    }
}
