package 기능개발;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answers = new int[100];
        List<Integer> finishedDays = findFinishedDays(progresses, speeds);

        int beforeValue = finishedDays.get(0);
        int bundleCount = 0;
        int release = 0;

        while (!finishedDays.isEmpty()) {
            if (beforeValue >= finishedDays.get(0)) {
                finishedDays.remove(0);
                bundleCount++;
                answers[release] = bundleCount;
            }
            else {
                beforeValue = finishedDays.get(0);
                bundleCount = 0;
                release++;
            }
        }

        return Arrays.stream(answers)
                .filter(it -> it != 0)
                .toArray();
    }

    private List<Integer> findFinishedDays(int[] progresses, int[] speeds) {
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            results.add((int) Math.ceil((double) (100 - progress) / (double) speed));
        }

        return results;
    }

    public static void main(String[] args) {
        int[] progresses = new int[]{95, 90, 99, 99, 80, 99};
        int[] speeds = new int[]{1, 1, 1, 1, 1, 1};

        Solution solution = new Solution();
        int[] answers = solution.solution(progresses, speeds);

        System.out.println(Arrays.toString(answers));
    }
}
