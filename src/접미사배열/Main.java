package 접미사배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] suffix = new String[input.length()];
        StringBuilder sb = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            suffix[i] = sb.insert(0, input.charAt(i)).toString();
        }
        Arrays.sort(suffix);
        sb.setLength(0);
        for (String s : suffix) {
            sb.append(s).append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
