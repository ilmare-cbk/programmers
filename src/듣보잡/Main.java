package 듣보잡;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> newbie = new HashMap<>();
        for (int i = 0; i < N + M; i++) {
            String name = br.readLine();
            newbie.put(name, newbie.getOrDefault(name, 0) + 1);
        }
        List<String> results = newbie.entrySet()
                .stream()
                .filter(it -> it.getValue() > 1)
                .map(Map.Entry::getKey)
                .sorted(Comparator.comparing(it -> it))
                .collect(Collectors.toList());
        bw.write(results.size() + System.lineSeparator());
        for (String result : results) {
            bw.write(result + System.lineSeparator());
        }
        bw.flush();
        bw.close();
    }
}
