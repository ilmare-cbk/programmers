package Q1.step4;

public class Solution {
    public int solution(int H, int W, int[] D) {
        int answer = 0;
        int maxLanLength = 0;
        int minLanLength = Integer.MAX_VALUE;
        int[] addedLanLengths = new int[200000];

        for (int lanLength : D) {
            if (lanLength >= H) {
                answer++;
                maxLanLength = Math.max(lanLength - H, maxLanLength);
                minLanLength = Math.min(lanLength - H, minLanLength);
                if (lanLength > H) {
                    addedLanLengths[lanLength - H - 1]++;
                }
                continue;
            }

            int key = H - lanLength - 1;
            for (int i = Math.max(key, minLanLength - 1); i < maxLanLength; i++) {
                if (addedLanLengths[i] != 0) {
                    answer++;
                    addedLanLengths[i]--;
                    break;
                }
            }
        }
        return answer;
    }
}
