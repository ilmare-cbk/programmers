package 수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        String[] numbers = br.readLine().split(" ");
        Map<String, Boolean> numMap = new HashMap();
        for (String number : numbers) {
            numMap.put(number, true);
        }
        br.readLine();
        String[] targets = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for (String target : targets) {
            Boolean exist = numMap.getOrDefault(target, false);
            if (exist) {
                sb.append("1").append(System.lineSeparator());
            } else {
                sb.append("0").append(System.lineSeparator());
            }
        }
        System.out.println(sb);
    }
}
