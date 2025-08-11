package P388351;

/**
 * 유연근무제
 */
public class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int N = schedules.length;
        int[] cnt = new int[N]; // 직원별 정상출근 횟수

        for (int s = 0; s < schedules.length; s++) {
            int i = startday - 1;
            int limit = (schedules[s] / 100 + ((schedules[s] % 100) + 10) / 60) * 100 + (((schedules[s] % 100) + 10) % 60);
            int[] timelog = timelogs[s];
            for (int t : timelog) {
                int day = (i++) % 7;
                if (day == 5 || day == 6) continue;
                if (t <= limit) {
                    cnt[s]++;
                }
            }
        }

        for (int c : cnt) {
            if (c == 5) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(
                solution.solution(
                        new int[]{700, 800, 1100},
                        new int[][]{{710, 2359, 1050, 700, 650, 631, 659},
                                {800, 801, 805, 800, 759, 810, 809},
                                {1105, 1001, 1002, 600, 1059, 1001, 1100}},
                        5
                )
        );
    }
}
