package Q2568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 전깃줄 - 2
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] line1 = new int[500001];
        int[] line2 = new int[500001];

        int N = Integer.parseInt(br.readLine());
        int size = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            line1[n1] = n2;
            line2[n2] = n1;
            size = Math.max(size, Math.max(n1, n2));
        }

        List<Integer> lis = new ArrayList<>();
        int[] trace = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            int key = line1[i];

            if (key == 0) continue;
            int idx = binarySearch(key, lis);

            if (lis.size() == idx) {
                lis.add(key);
            } else {
                lis.set(idx, key);
            }

            if (idx == 0) {
                trace[key] = 0;
            } else {
                trace[key] = lis.get(idx - 1);
            }
        }

        int idx = lis.get(lis.size() - 1);
        Set<Integer> connected = new HashSet<>();
        while (idx != 0) {
            connected.add(line2[idx]);
            idx = trace[idx];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(N - lis.size()).append(System.lineSeparator());

        for (int i = 1; i <= size; i++) {
            if (line1[i] == 0) continue;
            if (!connected.contains(i)) {
                sb.append(i).append(System.lineSeparator());
            }
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
