package 요세푸스문제0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int N = Integer.parseInt(nums[0]);
        int K = Integer.parseInt(nums[1]);
        List<Integer> q = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int idx = 0;
        while (!q.isEmpty()) {
            idx = getIdx(K, q, idx);
            Integer n = q.get(idx);
            sb.append(n);
            q.remove(n);
            if (q.size() != 0) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
    }

    private static int getIdx(int K, List<Integer> q, int idx) {
        idx = (idx + K - 1) % q.size();
        while (idx >= q.size()) {
            idx = idx % q.size();
        }
        return idx;
    }
}
