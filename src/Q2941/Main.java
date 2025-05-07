package Q2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 크로아티아 알파벳
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        List<String> alphabet = new ArrayList<>();
        alphabet.add("c=");
        alphabet.add("c-");
        alphabet.add("dz=");
        alphabet.add("d-");
        alphabet.add("lj");
        alphabet.add("nj");
        alphabet.add("s=");
        alphabet.add("z=");

        int answer = 0;
        int h = 0;
        while (h < s.length()) {
            boolean catched = false;
            int t = Math.min(h + 3, s.length());
            for (; t > h; t--) {
                String str = s.substring(h, t);
                if (alphabet.contains(str)) {
                    h = t;
                    catched = true;
                    break;
                }
            }
            if (!catched) h++;
            answer++;
        }


        System.out.println(answer);
    }
}
