package 주차요금계산;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

/**
 * fees[0] = 기본 시간(분)
 * fees[1] = 기본 요금(원)
 * fees[2] = 단위 시간(분)
 * fees[3] = 단위 요금(원)
 * <p>
 * records[0] = 시각(시:분)
 * records[1] = 차량 번호
 * records[2] = 내역 (입차/출차)
 * <p>
 * 차량 번호 오름차순으로 리턴
 */
public class Solution {
    public int[] solution(int[] fees, String[] records) {

        List<Record> recordList = new ArrayList<>();

        for (String record : records) {
            String[] recordToken = record.split(" ");
            recordList.add(new Record(recordToken[0], recordToken[1]));
        }

        Map<String, List<Record>> recordsByCar = recordList.stream()
                .collect(Collectors.groupingBy(Record::getCarNumber))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        int[] answer = new int[recordsByCar.size()];
        int index = 0;
        for (Map.Entry<String, List<Record>> entry : recordsByCar.entrySet()) {
            answer[index] = calculate(entry.getValue(), fees);
            index++;
        }

        return answer;
    }

    private int calculate(List<Record> records, int[] fees) {

        // 1. 누적 주차 시간(분) 구하기
        int accumulatedTime = calculateAccumulatedTime(records);

        // 2. 주차 요금 (원) 구하기
        // 2-1 누적 주차 시간이 기본 시간 이하인 경우
        // 2-2 누적 주차 시간이 기본 시간 초과인 경우
        // 2-2-1 식 : defaultCharge + ((누적 주차 시간 - 기본 시간)/(단위 시간)) * 단위 요금
        return calculateCharge(accumulatedTime, fees);
    }

    private int calculateAccumulatedTime(List<Record> records) {
        int accumulatedTime = 0;
        for (int i = 0; i < records.size(); i = i + 2) {
            Record inRecord = records.get(i);
            if (i + 1 < records.size()) {
                Record outRecord = records.get(i + 1);
                if (outRecord.getMin() < inRecord.getMin()) {
                    accumulatedTime += ((outRecord.getHour() - 1 - inRecord.getHour()) * 60) + (outRecord.getMin() + 60 - inRecord.getMin());
                } else {
                    accumulatedTime += ((outRecord.getHour() - inRecord.getHour()) * 60) + (outRecord.getMin() - inRecord.getMin());
                }
            } else {
                accumulatedTime += ((23 - inRecord.getHour()) * 60) + (59 - inRecord.getMin());
            }
        }
        return accumulatedTime;
    }

    private int calculateCharge(int accumulatedTime, int[] fees) {
        int defaultChargeTime = fees[0];
        int defaultCharge = fees[1];
        int criteriaTime = fees[2];
        int criteriaCharge = fees[3];

        if (accumulatedTime <= defaultChargeTime) {
            return defaultCharge;
        }

        // defaultCharge + ((누적 주차 시간 - 기본 시간)/(단위 시간)) * 단위 요금
        return defaultCharge +
                ((BigDecimal.valueOf(accumulatedTime - defaultChargeTime)
                        .divide(BigDecimal.valueOf(criteriaTime), RoundingMode.CEILING))
                        .intValue()) * criteriaCharge;
    }

    private class Record {
        private int hour;
        private int min;
        private String carNumber;

        public Record(String time, String carNumber) {
            String[] timeToken = time.split(":");
            this.hour = Integer.parseInt(timeToken[0]);
            this.min = Integer.parseInt(timeToken[1]);
            this.carNumber = carNumber;
        }

        public int getHour() {
            return hour;
        }

        public int getMin() {
            return min;
        }

        public String getCarNumber() {
            return carNumber;
        }

    }

    public static void main(String[] args) {
        int[] fees = new int[]{180, 5000, 10, 600};
        String[] records = new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        Solution solution = new Solution();
        int[] answer = solution.solution(fees, records);

        System.out.println(Arrays.toString(Arrays.stream(answer).toArray()));
    }
}
