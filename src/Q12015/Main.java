package Q12015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 가장 긴 증가하는 부분 수열 2
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
        List<Integer> lis = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int key = arr[i];
            int idx = binarySearch(key, lis);

            if (idx == lis.size()) {
                lis.add(key);
            } else {
                lis.set(idx, key);
            }
        }

        System.out.println(lis.size());
    }

    private static int binarySearch(int key, List<Integer> lis) {
        int low = 0, high = lis.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (lis.get(mid) == key) {
                return mid;
            } else if (lis.get(mid) < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low; // lower_bound 위치 반환
    }
}
