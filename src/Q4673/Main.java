package Q4673;

import java.util.Arrays;

/**
 * 셀프 넘버
 */
public class Main {
    public static void main(String[] args) {
        boolean[] self = new boolean[10036];
        Arrays.fill(self, true);

        for (int i = 1; i <= 10000; i++) {
            int sum = i;
            int temp = i;
            while (temp != 0) {
                sum += temp % 10;
                temp = (temp - temp % 10) / 10;
            }
            self[sum] = false;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10000; i++) {
            if (self[i]) sb.append(i).append(System.lineSeparator());
        }

        System.out.println(sb);
    }
}
