package Q2631;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 줄세우기
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        List<Integer> lis = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            int key = arr[i];
            int idx = binarySearch(key, lis);

            if (idx == lis.size()) {
                lis.add(key);
            } else {
                lis.set(idx, key);
            }
        }

        System.out.println(N - lis.size());
    }

    private static int binarySearch(int key, List<Integer> lis) {
        int low = 0, high = lis.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (lis.get(mid) == key) return mid;
            else if (lis.get(mid) < key) low = mid + 1;
            else high = mid - 1;
        }

        return low;
    }
}
