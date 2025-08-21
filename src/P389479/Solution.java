package P389479;

import java.util.ArrayList;
import java.util.List;

/**
 * 서버 증설 횟수
 */
public class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        List<Server> servers = new ArrayList<>();

        for (int i = 0; i < 24; i++) {
            int p = players[i];
            // 필요한 서버 수
            int serverCnt = p / m;

            // 현재 운영중인 서버 수
            int currentServer = 0;
            for (int j = 0; j < servers.size(); j++) {
                if (servers.get(j).isAvailable(i, k)) {
                    currentServer++;
                }
            }
            // 필요한 수 만큼 서버 증설
            for (int s = 1; s <= serverCnt - currentServer; s++) {
                servers.add(new Server(i));
            }
        }

        return servers.size();
    }

    private static class Server {
        int startTime;

        public Server(int startTime) {
            this.startTime = startTime;
        }

        public boolean isAvailable(int currentTime, int k) {
            return currentTime - startTime < k;
        }
    }
}
