package first캐시;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<String> lruCaches = new ArrayList<>();

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        for (String city : cities) {
            if (isHit(lruCaches, cacheSize, city.toLowerCase())) {
                answer += 1;
            }
            else {
                answer += 5;
            }
        }
        return answer;
    }

    private boolean isHit(List<String> lruCaches, int cacheSize, String city) {
        if (lruCaches.contains(city)) {
            lruCaches.remove(city);
            lruCaches.add(city);
            return true;
        }

        caching(lruCaches, cacheSize, city);
        return false;
    }

    private void caching(List<String> lruCaches, int cacheSize, String city) {
        if (cacheSize == 0) {
            return;
        }

        if (lruCaches.size() == cacheSize) {
            lruCaches.remove(0);
        }
        lruCaches.add(city);
    }

    public static void main(String[] args) {
        int cacheSize = 0;
        String[] cities = new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        Solution solution = new Solution();
        int answer = solution.solution(cacheSize, cities);

        System.out.println(answer);
    }

}
