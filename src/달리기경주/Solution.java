package 달리기경주;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

    public String[] solution(String[] players, String[] callings) {
        List<String> playerGroup = Arrays.stream(players).collect(Collectors.toList());

        Map<String, Integer> indexByPlayer = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            indexByPlayer.put(players[i], i);
        }

        for (String calling : callings) {
            int index = indexByPlayer.get(calling);
            if (index == 0) {
                continue;
            }
            playerGroup.remove(index);
            playerGroup.add(index - 1, calling);

            indexByPlayer.put(calling, index - 1);

            String player = playerGroup.get(index);
            indexByPlayer.put(player, indexByPlayer.get(player) + 1);
        }
        return playerGroup.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] players = new String[]{"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = new String[]{"kai", "kai", "mine", "mine"};
        String[] answers = solution.solution(players, callings);
        System.out.println(Arrays.toString(Arrays.stream(answers).toArray()));
    }
}
