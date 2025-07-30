package P258707;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * n + 1 카드게임
 */
public class Solution {
    private static boolean[] myCards;
    private static Set<Integer> selectableCards = new HashSet<>();
    private static int n;

    public static void main(String[] args) {
//        System.out.println(solution(2, new int[]{5, 8, 1, 2, 9, 4, 12, 11, 3, 10, 6, 7}));
//        System.out.println(solution(2, new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(solution(4, new int[]{2, 17, 1, 18, 4, 5, 13, 12, 6, 7, 3, 15, 9, 8, 11, 10, 16, 14}));
//        System.out.println(solution(3, new int[]{1, 6, 2, 5, 3, 4}));
//        System.out.println(solution(2, new int[]{1, 2, 3, 10, 6, 7, 11, 12, 4, 5, 8, 9}));
//        System.out.println(solution(4, new int[]{1, 17, 2, 3, 4, 5, 6, 7, 13, 12, 8, 9, 10, 11, 14, 15, 16, 18}));
//        System.out.println(solution(1, new int[]{6, 2, 1, 4, 5, 3}));
//        System.out.println(solution(8, new int[]{1, 12, 2, 11, 3, 10, 4, 9, 5, 8, 6, 7}));
//        System.out.println(solution(4, new int[]{3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4}));
//        System.out.println(solution(3, new int[]{1, 2, 3, 4, 5, 8, 6, 7, 9, 10, 11, 12}));
    }

    public static int solution(int coin, int[] cards) {
        int answer = 1;
        n = cards.length;
        myCards = new boolean[n + 1];
        int pairCnt = 0;

        for (int i = 0; i < n / 3; i++) {
            if (myCards[n + 1 - cards[i]]) {
                pairCnt++;
                myCards[n + 1 - cards[i]] = false;
            } else {
                myCards[cards[i]] = true;
            }
        }

        for (int i = n / 3; i < n; i += 2) {
            for (int j = 0; j < 2; j++) {
                if (coin > 0 && myCards[n + 1 - cards[i + j]]) {
                    myCards[n + 1 - cards[i + j]] = false;
                    pairCnt++;
                    coin--;
                } else {
                    selectableCards.add(cards[i + j]);
                }
            }

            if (pairCnt < 1 && coin > 1) {
                List<Integer> remove = new ArrayList<>();
                for (Integer selectableCard : selectableCards) {
                    if (selectableCards.contains(n + 1 - selectableCard)) {
                        remove.add(selectableCard);
                        remove.add(n + 1 - selectableCard);
                        coin -= 2;
                        pairCnt++;
                        break;
                    }
                }
                remove.forEach(selectableCards::remove);
            }


            if (pairCnt < 1) { // 더 이상 낼 수 있는 n + 1 조합이 없을 때 종료.
                break;
            }

            answer++;
            pairCnt--; // 다음 라운드 진행을 위해 n + 1 조합 소비.
        }

        return answer;
    }

}
