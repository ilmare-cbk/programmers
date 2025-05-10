package Q14002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 가장 긴 증가하는 부분 수열 4
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> lis = new ArrayList<>();
        int[] path = new int[N];
        for (int i = 0; i < N; i++) {
            int key = arr[i];
            int idx = binarySearch(key, lis);

            if (idx == lis.size()) {
                lis.add(key);
            } else {
                lis.set(idx, key);
            }

            path[i] = idx;
        }

        int target = lis.size() - 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = N - 1; i >= 0; i--) {
            if (path[i] == target) {
                stack.push(arr[i]);
                target--;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(lis.size()).append(System.lineSeparator());
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
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

