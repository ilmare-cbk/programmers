package 프로세스;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        List<Integer> sortedPriorities = Arrays.stream(priorities).boxed().sorted().collect(Collectors.toList());

        Queue<Process> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Process(i, priorities[i]));
        }

        while (!queue.isEmpty()) {
            Process process = queue.poll();
            Integer maxPriority = sortedPriorities.get(sortedPriorities.size() - 1);
            if (process.goe(maxPriority)) {
                sortedPriorities.remove(sortedPriorities.size() - 1);
                answer++;
                if (process.equalsIndex(location)) {
                    break;
                }
            } else {
                queue.add(process);
            }
        }

        return answer;
    }

    private static class Process {
        int index;
        int priority;

        public Process(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }

        public boolean goe(Integer priority) {
            return this.priority >= priority;
        }

        public boolean equalsIndex(int location) {
            return this.index == location;
        }
    }

    public static void main(String[] args) {
        int[] priorities = new int[]{2, 1, 3, 2};
        int location = 2;

        Solution solution = new Solution();

        int answers = solution.solution(priorities, location);
        System.out.println(answers);
    }
}
