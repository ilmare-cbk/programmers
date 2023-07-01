package 다리를지나는트럭;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며, 다리는 weight 이하까지의 무게를 견딜 수 있습니다.
 */
public class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Truck> trucks = Arrays.stream(truck_weights)
                .mapToObj(it -> new Truck(it, 0))
                .collect(Collectors.toCollection(LinkedList::new));

        Queue<Truck> bridge = new LinkedList<>();

        while (!trucks.isEmpty() || !bridge.isEmpty()) {
            // 다리에서 나옴
            if (!bridge.isEmpty()) {
                Truck truck = bridge.peek();
                if (truck.elapsedTime >= bridge_length) {
                    bridge.poll();
                }
            }

            // 다리에 진입
            if (!trucks.isEmpty()) {
                Truck truck = trucks.peek();
                if (bridgeAvailable(bridge_length, weight, bridge, truck)) {
                    bridge.add(trucks.poll());
                }
            }

            answer++;
            bridge.forEach(Truck::increaseElapsedTime);
        }

        return answer;
    }

    private boolean bridgeAvailable(int bridge_length, int weight, Queue<Truck> bridge, Truck truck) {
        return bridge.stream().map(it -> it.weight).reduce(0, Integer::sum) + truck.weight <= weight &&
                bridge.size() < bridge_length;
    }

    private class Truck {
        int weight;
        int elapsedTime;

        public Truck(int weight, int elapsedTime) {
            this.weight = weight;
            this.elapsedTime = elapsedTime;
        }

        public void increaseElapsedTime() {
            this.elapsedTime++;
        }
    }

    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = new int[]{7,4,5,6};

        Solution solution = new Solution();
        int answers = solution.solution(bridge_length, weight, truck_weights);

        System.out.println(answers);
    }
}
