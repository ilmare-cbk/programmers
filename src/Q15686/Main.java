package Q15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 치킨 배달
 */
public class Main {
    private static int N;
    private static int M;
    private static List<Position> houses = new ArrayList<>();
    private static List<Position> stores = new ArrayList<>();
    private static List<Integer> selectedStores = new ArrayList<>();
    private static int answer = Integer.MAX_VALUE;
    private static int[][] dist;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        for (int i = 0; i < N; i++) {
            String[] pos = br.readLine().split(" ");
            for (int j = 0; j < pos.length; j++) {
                int n = Integer.parseInt(pos[j]);
                if (n == 1) {
                    houses.add(new Position(i + 1, j + 1));
                }
                if (n == 2) {
                    stores.add(new Position(i + 1, j + 1));
                }
            }
        }

        // 집 - 치킨집 거리를 미리 구함.
        dist = new int[houses.size()][stores.size()];
        for (int i = 0; i < houses.size(); i++) {
            Position house = houses.get(i);
            for (int j = 0; j < stores.size(); j++) {
                Position store = stores.get(j);
                dist[i][j] = Math.abs(house.r - store.r) + Math.abs(house.c - store.c);
            }
        }

        find(0);
        System.out.println(answer);
    }

    private static void find(int start) {
        if (selectedStores.size() == M) {
            int total_d = 0;
            for (int i = 0; i < houses.size(); i++) {
                int d = Integer.MAX_VALUE;
                for (Integer storeIdx : selectedStores) {
                    d = Math.min(d, dist[i][storeIdx]);
                }
                total_d += d;
            }
            answer = Math.min(answer, total_d);
            return;
        }

        for (int i = start; i < stores.size(); i++) {
            selectedStores.add(i);
            find(i + 1);
            selectedStores.remove(selectedStores.size() - 1);
        }
    }

    private static class Position {
        int r;
        int c;

        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }
    }
}
