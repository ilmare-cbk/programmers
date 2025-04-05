package Q2143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 두 배열의 합
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        int[] a = makeSubArray(n, A);
        int[] b = makeSubArray(m, B);
        Map<Integer, Integer> map = new HashMap<>(); // key : 부배열 원소의 합 , value : 갯수
        for (Integer num : b) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        long answer = 0;
        for (Integer num : a) {
            if (map.getOrDefault(T - num, 0) > 0) {
                answer += map.get(T - num);
            }
        }
        System.out.println(answer);
    }

    private static int[] makeSubArray(int n, int[] A) {
        int[] result = new int[n * (n + 1) / 2];
        int sum, idx = 0;
        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum += A[j];
                result[idx++] = sum;
            }
        }
        return result;
    }
}
/*
5
4
1 3 1 2
3
1 3 2

5
3
1 3 2
4
1 3 1 2
 */