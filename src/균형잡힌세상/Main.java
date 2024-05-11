package 균형잡힌세상;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String str = br.readLine();
            if (str.equals(".")) {
                break;
            }
            List<String> q = new ArrayList<>();
            String[] p = str.split("");
            for (String s : p) {
                switch (s) {
                    case "(":
                    case "[":
                        q.add(s);
                        break;
                    case ")":
                        if (!q.isEmpty() && q.get(q.size() - 1).equals("(")) {
                            q.remove(q.size() - 1);
                        } else {
                            q.add(s);
                        }
                        break;
                    case "]":
                        if (!q.isEmpty() && q.get(q.size() - 1).equals("[")) {
                            q.remove(q.size() - 1);
                        } else {
                            q.add(s);
                        }
                        break;
                }
            }
            if (q.isEmpty()) {
                sb.append("yes").append(System.lineSeparator());
            }
            else {
                sb.append("no").append(System.lineSeparator());
            }
        }
        System.out.println(sb);
    }
}
