package Q2.step2;

public class Solution {
    public int solution(int N, int[] F, int[] B) {
        int answer = -1;
        if (!enemyExist(B)) {
            return answer;
        }

        for (int i = 0; i < F.length; i++) {
            if (F[i] != B[0]) {
                continue;
            }
            if (identical(F, B, i)) {
                answer = i + 1;
                break;
            }
        }


        return answer;
    }

    private boolean identical(int[] F, int[] B, int index) {
        if (F.length - index < B.length) {
            return false;
        }

        for (int i = 0; i < B.length; i++) {
            if (F[index + i] != B[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean enemyExist(int[] B) {
        int enemy = 1;
        int[] sound = new int[9];
        for (int f : B) {
            if (f == 0) {
                enemy = 0;
                break;
            }
            sound[f]++;
            if (sound[f] > 1) {
                enemy = 0;
                break;
            }
        }
        return enemy == 1;
    }

    public static void main(String[] args) {
        int N = 20;
        int[] F = new int[]{10,5,1,2,3,4,5,6,7,8,5,3,1,2,3,4,5,6,7,8};
        int[] B = new int[]{1,2,3,4,5,6,7,8};

        Solution solution = new Solution();
        int answer = solution.solution(N, F, B);

        System.out.println(answer);
    }
}
