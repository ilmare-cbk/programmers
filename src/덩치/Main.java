package 덩치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());

        Member[] members = new Member[N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int weight = Integer.parseInt(input[0]);
            int height = Integer.parseInt(input[1]);
            members[i] = new Member(weight, height);
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < members.length; i++) {
            int rank = 1;
            for (int j = 0; j < members.length; j++) {
                if (i == j) continue;
                if (members[i].compareTo(members[j]) < 0) {
                    rank++;
                }
            }
            sb.append(rank).append(" ");
        }
        System.out.println(sb);
    }

    private static class Member implements Comparable<Member> {
        private int weight;
        private int height;

        public Member(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }


        @Override
        public int compareTo(Member o) {
            return weight - o.weight > 0 && height - o.height > 0 ? 1 : weight - o.weight < 0 && height - o.height < 0 ? -1 : 0;
        }
    }
}
