package 덧칠하기;

public class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int start;
        int end = 0;
        for (int sectionNum : section) {
            if (end >= sectionNum) {
                continue;
            }
            start = sectionNum;
            end = start + m - 1;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 1;
        int[] section = new int[]{1,2,3,4};
        Solution solution = new Solution();
        int answer = solution.solution(n, m, section);
        System.out.println(answer);
    }
}
