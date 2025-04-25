package Q19621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 회의실 배정 2
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Room[] rooms = new Room[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            rooms[i] = new Room(s, e, size);
        }
        Arrays.sort(rooms);

        int[] dp = new int[N + 1];
        dp[1] = rooms[0].size;

        for (int i = 2; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + rooms[i - 1].size);
        }

        System.out.println(dp[N]);
    }

    private static class Room implements Comparable<Room> {
        int s;
        int e;
        int size;

        public Room(int s, int e, int size) {
            this.s = s;
            this.e = e;
            this.size = size;
        }

        @Override
        public int compareTo(Room o) {
            return this.s = o.s;
        }
    }
}
