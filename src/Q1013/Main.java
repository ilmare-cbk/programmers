package Q1013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Contact
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String regex = "(100+1+|01)+";
        Pattern pattern = Pattern.compile(regex);
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            String line = br.readLine();
            Matcher matcher = pattern.matcher(line);
            if (matcher.matches()) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb);
    }
}
