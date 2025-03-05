package Q30804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 과일 탕후루
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] fruits = br.readLine().split(" ");

        int l = 0;
        int answer = 0;
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int r = 0; r < N; r++) {
            int fruit = Integer.parseInt(fruits[r]);
            countMap.put(fruit, countMap.getOrDefault(fruit, 0) + 1);

            while (countMap.size() > 2) {
                int leftFruit = Integer.parseInt(fruits[l]);
                countMap.put(leftFruit, countMap.get(leftFruit) - 1);
                if (countMap.get(leftFruit) == 0) {
                    countMap.remove(leftFruit);
                }
                l++;
            }
            answer = Math.max(answer, r - l + 1);
        }
        System.out.println(answer);
    }
}
