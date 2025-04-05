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
        int[] A = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> a = makeSubArray(n, A);
        List<Integer> b = makeSubArray(m, B);
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

    private static List<Integer> makeSubArray(int n, int[] A) {
        List<Integer> result = new ArrayList<>(); // 부배열
        int sum;
        for (int i = 1; i <= n; i++) {
            sum = 0;
            for (int j = i; j <= n; j++) {
                sum += A[j];
                result.add(sum);
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