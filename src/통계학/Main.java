package 통계학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int sum = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> countByNumber = new HashMap<>();
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            sum += nums[i];
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
            int count = countByNumber.getOrDefault(nums[i], 0);
            countByNumber.put(nums[i], count + 1);
        }
        Arrays.sort(nums);
        String str = Math.round(((double) sum) / (double) N) + System.lineSeparator() +
                nums[N / 2] + System.lineSeparator() +
                getMaxCountNumber(countByNumber) + System.lineSeparator() +
                (nums[N - 1] - nums[0]);
        System.out.println(str);

    }

    private static int getMaxCountNumber(Map<Integer, Integer> countByNumber) {
        Integer maxCount = countByNumber.values()
                .stream().max(Comparator.comparing(it -> it)).get();
        List<Integer> numbers = countByNumber.entrySet()
                .stream()
                .filter(it -> it.getValue().equals(maxCount))
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        return numbers.size() == 1 ? numbers.get(0) : numbers.get(1);
    }

}
