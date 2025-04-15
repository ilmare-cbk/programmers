package Q7453;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 합이 0인 네 정수
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int size = n * n;
        int[] AB = new int[size];
        int[] CD = new int[size];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                AB[i * n + j] = A[i] + B[j];
                CD[i * n + j] = C[i] + D[j];
            }
        }
        Arrays.sort(AB);
        Arrays.sort(CD);

        long cnt = 0;
        int l = 0;
        int r = size - 1;

        while (l < size && r >= 0) {
            int ab = AB[l];
            int cd = CD[r];
            int sum = ab + cd;

            if (sum == 0) {
                int abCnt = 0;
                int cdCnt = 0;

                while (l < size && AB[l] == ab) {
                    abCnt++;
                    l++;
                }

                while (r >= 0 && CD[r] == cd) {
                    cdCnt++;
                    r--;
                }

                cnt += (long) abCnt * cdCnt;
            } else if (sum < 0) {
                l++;
            } else {
                r--;
            }
        }

        System.out.println(cnt);
    }
}
