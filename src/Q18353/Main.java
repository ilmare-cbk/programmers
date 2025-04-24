package Q18353;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 병사 배치하기
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

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int key = arr[i];
            int idx = binarySearch(key, list);

            if (idx == list.size()) {
                list.add(key);
            } else {
                list.set(idx, key);
            }
        }

        System.out.println(N - list.size());
    }

    private static int binarySearch(int key, List<Integer> list) {
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (list.get(mid) == key) return mid;
            else if (list.get(mid) > key) low = mid + 1;
            else high = mid - 1;
        }

        return low;
    }
}
