package P42627;

import java.util.*;

/**
 * 디스크 컨트롤러
 */
public class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Task> tasks = new PriorityQueue<>();

        int currentTime = jobs[0][0];
        int idx = 0;

        while (idx < jobs.length || !tasks.isEmpty()) {

            for (int i = idx; i < jobs.length; i++) {
                int rt = jobs[i][0];
                if (rt > currentTime) {
                    break;
                }
                tasks.add(new Task(idx, rt, jobs[i][1]));
                idx++;
            }

            if (tasks.isEmpty()) {
                currentTime = jobs[idx][0];
                continue;
            }

            if (!tasks.isEmpty()) {
                Task task = tasks.poll();
                task.startTime = currentTime;

                currentTime += task.taskTime;
                answer += task.turnAroundTime();
            }
        }

        return answer / jobs.length;
    }

    private static class Task implements Comparable<Task> {
        int n; // 작업번호
        int requestTime; // 요청시각
        int taskTime; // 소요시간
        int startTime; // 작업 시작시간

        public Task(int n, int requestTime, int taskTime) {
            this.n = n;
            this.requestTime = requestTime;
            this.taskTime = taskTime;
        }

        public int turnAroundTime() {
            return (this.startTime + this.taskTime) - this.requestTime;
        }


        @Override
        public int compareTo(Task o) {
            if (this.taskTime != o.taskTime) return this.taskTime - o.taskTime;
            else if (this.requestTime != o.requestTime) return this.requestTime - o.requestTime;
            else return this.n - o.n;
        }
    }
}
