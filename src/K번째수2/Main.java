package K번째수2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        int[] arr = new int[N];
        String[] s1 = br.readLine().split(" ");
        for (int i = 0; i < s1.length; i++) {
            arr[i] = Integer.parseInt(s1[i]);
        }
        Arrays.sort(arr);
        System.out.println(arr[K - 1]);
    }
}
