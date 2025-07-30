package P389478;

/**
 * 택배 상자 꺼내기
 */
public class Main {
    public static void main(String[] args) {
//        System.out.println(solution(22, 6, 1));
//        System.out.println(solution(22, 6, 6));
//        System.out.println(solution(13, 3, 6));
        System.out.println(solution(13, 3, 13));
    }

    public static int solution(int n, int w, int num) {
        int answer = 1;
        while (true) {
            num = num + w;
            int idx = num % w == 0 ? w : num % w;
            int height = num % w != 0 ? num / w + 1 : num / w;
            num = height * w - idx + 1;
            if (num > n) break;
            answer++;
        }
        return answer;
    }
}
