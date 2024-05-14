package 비밀번호찾기;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, String> dictionary = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        while (N > 0) {
            st = new StringTokenizer(br.readLine());
            dictionary.put(st.nextToken(), st.nextToken());
            N--;
        }
        while (M > 0) {
            st = new StringTokenizer(br.readLine());
            bw.write(dictionary.get(st.nextToken()) + System.lineSeparator());
            M--;
        }
        bw.flush();
        bw.close();
    }
}
