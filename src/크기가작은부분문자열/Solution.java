package 크기가작은부분문자열;

public class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long longP = Long.parseLong(p);

        for (int i = 0; i <= t.length() - p.length(); i++) {
            Long longT = Long.valueOf(t.substring(i, i + p.length()));
            if (longT.compareTo(longP) <= 0) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String t = "10203";
        String p = "15";

        Solution solution = new Solution();
        int answer = solution.solution(t, p);

        System.out.println(answer);
    }
}
