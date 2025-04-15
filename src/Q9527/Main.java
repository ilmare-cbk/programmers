package Q9527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1의 개수 세기
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        // B까지의 모든 이진수의 1의 합에서 A - 1까지의 모든 이진수의 1의 합을 뺀다.
        // = A ~ B까지의 모든 이진수의 1의 합
        System.out.println(sum(B) - sum(A - 1));
    }

    private static long sum(long num) {
        long result = 0;
        for (int i = 0; i < 62; i++) {
            long n1 = 1L << (i + 1);
            long n2 = 1L << i;

            // 0부터 각 비트 자리의 규칙을 도출
            // 1번째 비트 : 01 반복
            // 2번째 비트 : 0011 반복
            // 3번째 비트 : 00001111 반복
            result += (num / n1) * n2 + Math.max(0, (num % n1) - (n1 - 1 - n2));
        }
        return result;
    }
}
