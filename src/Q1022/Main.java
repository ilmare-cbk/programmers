package Q1022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 소용돌이 예쁘게 출력하기
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        int[][] arr = new int[r2 - r1 + 1][c2 - c1 + 1];
        int maxLength = 0;
        for (int r = r1; r <= r2; r++) {
            for (int c = c1; c <= c2; c++) {
                int value = calculateValue(r, c);
                arr[r - r1][c - c1] = value;
                maxLength = Math.max(maxLength, String.valueOf(value).length());
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[r].length; c++) {
                int l = String.valueOf(arr[r][c]).length();
                while (l != maxLength) {
                    sb.append(" ");
                    l++;
                }
                sb.append(arr[r][c]).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private static int calculateValue(int r, int c) {
        int layer = Math.max(Math.abs(r), Math.abs(c));
        int n = 2 * layer + 1;
        int maxVal = n * n;

        if (r == layer) {
            return maxVal - (layer - c);
        } else if (r == -layer) {
            return maxVal - 2 * layer * 3 + (layer - c);
        } else if (c == layer) {
            return maxVal - 2 * layer * 3 - (r + layer);
        } else {
            return maxVal - 2 * layer - (layer - r);
        }
    }
}
