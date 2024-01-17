package 나이순정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] members = new String[N][3];
        for (int i = 0; i < N; i++) {
            String[] memberInfo = br.readLine().split(" ");
            members[i][0] = String.valueOf(i + 1); // 가입 순서
            members[i][1] = memberInfo[0]; // 나이
            members[i][2] = memberInfo[1]; // 이름
        }
        Arrays.sort(members, Comparator.comparing(m -> Integer.parseInt(m[0])));
        Arrays.sort(members, Comparator.comparing(m -> Integer.parseInt(m[1])));
        StringBuilder sb = new StringBuilder();
        for (String[] member : members) {
            sb.append(member[1]).append(" ").append(member[2]).append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
