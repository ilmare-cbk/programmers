package P43164;

import java.util.*;

/**
 * 여행경로
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(solution(
                        new String[][]{
                                {"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}
                        }
                ))
        );
    }

    private static boolean[] visited;
    private static String[] answer;

    public static String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];

        Arrays.sort(tickets, Comparator.comparing(t -> t[1]));
        List<String> path = new ArrayList<>();
        path.add("ICN");

        dfs("ICN", tickets, path);

        return answer;
    }

    private static void dfs(String from, String[][] tickets, List<String> path) {
        if (answer != null) return;

        if (path.size() == tickets.length + 1) {
            answer = path.toArray(new String[]{});
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (visited[i] || !tickets[i][0].equals(from)) continue;

            path.add(tickets[i][1]);
            visited[i] = true;

            dfs(tickets[i][1], tickets, path);

            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}
