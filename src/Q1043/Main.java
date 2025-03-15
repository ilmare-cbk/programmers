package Q1043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 거짓말
 */
public class Main {
    private static Map<Integer, List<Integer>> parties = new HashMap<>();
    private static Set<Integer> trues = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        String[] data = br.readLine().split(" ");
        for (int i = 1; i < data.length; i++) {
            trues.add(Integer.parseInt(data[i]));
        }
        for (int i = 0; i < M; i++) {
            String[] ps = br.readLine().split(" ");
            List<Integer> people = new ArrayList<>();
            for (int j = 1; j < ps.length; j++) {
                people.add(Integer.parseInt(ps[j]));
            }
            parties.put(i, people);
        }
        find();
        System.out.println(parties.size());
    }

    private static void find() {
        int size = parties.size();
        List<Integer> removeParties = new ArrayList<>();

        for (Map.Entry<Integer, List<Integer>> entry : parties.entrySet()) {
            List<Integer> people = entry.getValue();
            for (Integer person : people) {
                if (trues.contains(person)) {
                    trues.addAll(people);
                    removeParties.add(entry.getKey());
                }
            }
        }
        removeParties.forEach(r -> parties.remove(r));

        if (size != parties.size()) {
            find();
        }
    }
}
