package 평균구하기;

class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        answer = sum / (double) arr.length;
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        Solution solution = new Solution();
        double answer = solution.solution(arr);
        System.out.println(answer);
    }
}
