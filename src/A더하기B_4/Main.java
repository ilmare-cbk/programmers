package A더하기B_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringBuilder sb = new StringBuilder();
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            StringTokenizer st = new StringTokenizer(input);
            sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())).append(System.lineSeparator());
        }
        System.out.println(sb);
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        StringBuilder sb = new StringBuilder();
//        while (sc.hasNextLine()) {
//            sb.append(sc.nextInt() + sc.nextInt()).append(System.lineSeparator());
//        }
//        System.out.println(sb);
//    }
}
