package 스택수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> stack = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int cur = 1;
        while (n > 0) {
            int N = Integer.parseInt(br.readLine());
            if (!stack.contains(N)) {
                while (N >= cur) {
                    stack.add(cur);
                    sb.append("+").append(System.lineSeparator());
                    cur++;
                }
                stack.remove(stack.size() - 1);
                sb.append("-").append(System.lineSeparator());
            }
            else {
                if (stack.get(stack.size() - 1) == N) {
                    stack.remove(stack.size() - 1);
                    sb.append("-").append(System.lineSeparator());
                }
                else {
                    System.out.println("NO");
                    return;
                }
            }
            n--;
        }
        System.out.println(sb);
    }
}
