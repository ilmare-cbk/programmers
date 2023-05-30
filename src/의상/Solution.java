package 의상;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> clothesMap = makeClothesMap(clothes);
        for (Integer clothesCount : clothesMap.values()) {
            answer = answer * (clothesCount + 1);
        }
        return answer - 1;
    }

    private Map<String, Integer> makeClothesMap(String[][] clothes) {
        Map<String, Integer> clothesMap = new HashMap<>();
        for (String[] clothe : clothes) {
            Integer clothesCount = clothesMap.getOrDefault(clothe[1], 0);
            clothesMap.put(clothe[1], clothesCount + 1);
        }

        return clothesMap;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] clothes = new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int answer = solution.solution(clothes);

        System.out.println(answer);
    }
}
