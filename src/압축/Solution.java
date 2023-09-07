package 압축;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();

        Map<String, Integer> dictionary = new HashMap<>();
        init(dictionary);

        List<String> messages = Arrays.stream(msg.split("")).map(String::toUpperCase).collect(Collectors.toList());

        int index = 0;
        int cursor = 0;
        StringBuilder sb = new StringBuilder();
        while(cursor < messages.size()) {
            sb.setLength(0);
            for (int i = cursor; i < messages.size(); i++) {
                sb.append(messages.get(i));
                String newMessage = sb.toString();
                if (dictionary.get(newMessage) == null) {
                    dictionary.put(newMessage, dictionary.size() + 1);
                    break;
                }
                else {
                    index = dictionary.get(newMessage);
                }
                cursor++;
            }

            answer.add(index);
        }

        return answer.stream().mapToInt(it -> it).toArray();
    }

    private void init(Map<String, Integer> dictionary) {
        for (int i = 65; i <= 90; i++) {
            dictionary.put(String.valueOf((char) i), i - 64);
        }
    }

    public static void main(String[] args) {
        String msg = "TOBEORNOTTOBEORTOBEORNOT";
        Solution solution = new Solution();
        int[] answer = solution.solution(msg);
        System.out.println(Arrays.toString(Arrays.stream(answer).toArray()));
    }
}
