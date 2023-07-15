package 햄버거만들기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        int i = 0;
        List<Integer> burgerStartIdx = new ArrayList<>();
        List<Integer> ingredients = Arrays.stream(ingredient).boxed().collect(Collectors.toList());


        while (i < ingredients.size()) {
            if (possibleBurger(ingredients, i)) {
                answer++;

                for (int k = 0; k < 4; k++) {
                    ingredients.remove(i);
                }

                if (!burgerStartIdx.isEmpty()) {
                    i = burgerStartIdx.get(burgerStartIdx.size() - 1);
                    burgerStartIdx.remove(burgerStartIdx.size() - 1);
                }
                continue;
            }

            if (ingredients.size() > 4 && ingredients.get(i) == 1) {
                burgerStartIdx.add(i);
            }

            i++;

        }

        return answer;
    }

    private boolean possibleBurger(List<Integer> ingredients, int i) {
        return i + 4 <= ingredients.size() &&
                ingredients.get(i) == 1 &&
                ingredients.get(i + 1) == 2 &&
                ingredients.get(i + 2) == 3 &&
                ingredients.get(i + 3) == 1;
    }

    public static void main(String[] args) {
        int[] ingredient = new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1};
        Solution solution = new Solution();

        int answer = solution.solution(ingredient);

        System.out.println(answer);
    }
}
