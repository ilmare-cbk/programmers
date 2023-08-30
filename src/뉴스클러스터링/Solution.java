package 뉴스클러스터링;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Solution {
    public int solution(String str1, String str2) {
        int answer = 1;
        Pattern pattern = Pattern.compile("[A-Za-z]");
        List<String> str1Set = makeSet(str1, pattern);
        List<String> str2Set = makeSet(str2, pattern);

        int sum = str1Set.size() + str2Set.size();

        if (sum == 0) {
            return answer * 65536;
        }

        int intersection = findIntersectionCount(str1Set, str2Set);
        return (int) ((intersection / (double) (sum - intersection)) * 65536);
    }

    private List<String> makeSet(String str, Pattern pattern) {
        String[] split = str.split("");

        List<String> result = new ArrayList<>();
        for (int i = 0; i < split.length - 1; i++) {
            if (!pattern.matcher(split[i]).find() || !pattern.matcher(split[i + 1]).find()) {
                continue;
            }
            result.add(str.substring(i, i + 2).toLowerCase());
        }

        return result;
    }

    private int findIntersectionCount(List<String> str1Set, List<String> str2Set) {
        int before = str2Set.size();
        for (String s : str1Set) {
            str2Set.remove(s);
        }

        return before - str2Set.size();
    }

    public static void main(String[] args) {
        String str1 = "E=M*C^2";
        String str2 = "e=m*c^2";

        Solution solution = new Solution();
        int answer = solution.solution(str1, str2);

        System.out.println(answer);
    }
}
