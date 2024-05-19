package 좌표압축;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        LinkedHashSet<Integer> nums = new LinkedHashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            nums.add(arr[i]);
        }
        Map<Integer, Integer> indexOfNumber = new HashMap<>();
        AtomicInteger idx = new AtomicInteger(0);
        nums.stream()
                .sorted(Comparator.comparing(it -> it))
                .forEach(it -> indexOfNumber.put(it, idx.getAndIncrement()));
        for (int i : arr) {
            bw.write(indexOfNumber.get(i) + " ");
        }
        bw.flush();
        bw.close();
    }
}
