package Q25644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최대 상승
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int stock = arr[0];
        int answer = 0;
        for (int i = 1; i < N; i++) {
            if (arr[i] < stock) {
                stock = arr[i];
            } else {
                answer = Math.max(answer, arr[i] - stock);
            }
        }

        System.out.println(answer);
    }
}
