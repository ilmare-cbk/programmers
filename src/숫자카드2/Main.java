package 숫자카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();
        br.readLine();
        String[] numbers = br.readLine().split(" ");
        for (String number : numbers) {
            map.merge(Integer.parseInt(number), 1, Integer::sum);
        }
        br.readLine();
        String[] Ms = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for (String m : Ms) {
            sb.append(map.getOrDefault(Integer.parseInt(m), 0)).append(" ");
        }

        System.out.println(sb);
    }
}
