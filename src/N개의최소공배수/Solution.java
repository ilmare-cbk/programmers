package N개의최소공배수;

public class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        if (arr.length == 1) {
            return arr[0];
        }

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                answer = lcm(arr[i], arr[i + 1]);
            }
            answer = lcm(arr[i], answer);
        }
        return answer;
    }

    private int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
