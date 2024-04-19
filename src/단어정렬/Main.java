package 단어정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> words = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (!words.contains(word)) {
                words.add(word);
            }
        }
        words.sort((o1, o2) -> o1.length() != o2.length() ? o1.length() - o2.length(): o1.compareTo(o2));
        words.forEach(System.out::println);
    }
}
