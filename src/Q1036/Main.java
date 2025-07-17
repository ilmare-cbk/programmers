package Q1036;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

/**
 * 36진수
 */
public class Main {
    private static final BigInteger NUMERAL_SYSTEM = BigInteger.valueOf(36);
    private static final List<Character> selectedDigits = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String> numbers = new ArrayList<>();
        Map<Character, BigInteger> gainMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String number = br.readLine();
            numbers.add(number);
            for (int pos = 0; pos < number.length(); pos++) {
                char key = number.charAt(number.length() - 1 - pos);
                BigInteger gain = gainMap.getOrDefault(key, BigInteger.ZERO);
                gainMap.put(key, gain.add(NUMERAL_SYSTEM.pow(pos).multiply(BigInteger.valueOf(35 - to10(key)))));
            }
        }
        int K = Math.min(Integer.parseInt(br.readLine()), gainMap.size());

        List<Character> ketSet = new ArrayList<>(gainMap.keySet());
        ketSet.sort((k1, k2) -> gainMap.get(k2).compareTo(gainMap.get(k1)));
        for (int i = 0; i < K; i++) {
            selectedDigits.add(ketSet.get(i));
        }

        BigInteger sum = BigInteger.ZERO;
        for (String number : numbers) {
            for (int pos = 0; pos < number.length(); pos++) {
                char digit = convertToZIfSelected(number.charAt(number.length() - 1 - pos));
                sum = sum.add(NUMERAL_SYSTEM.pow(pos).multiply(BigInteger.valueOf(to10(digit))));
            }
        }

        if (sum.equals(BigInteger.ZERO)) {
            System.out.println(0);
            return;
        }

        StringBuilder sb = new StringBuilder();
        while (sum.compareTo(BigInteger.ZERO) > 0) {
            sb.append(to36(sum.remainder(NUMERAL_SYSTEM).intValue()));
            sum = sum.divide(NUMERAL_SYSTEM);
        }

        System.out.println(sb.reverse());
    }

    private static char convertToZIfSelected(char c) {
        if (selectedDigits.contains(c)) {
            return 'Z';
        }
        return c;
    }

    private static int to10(char c) {
        if (c >= '0' && c <= '9') {
            return (c - '0');
        }
        return (c - 55);
    }

    private static char to36(int num) {
        if (num >= 0 && num <= 9) {
            return (char) (num + 48);
        }
        return (char) (num + 55);
    }
}

//        int maxLength = 0;
//        Map<Integer, List<Character>> digitsByPosition = new HashMap<>();
//        for (int i = 0; i < N; i++) {
//            String nums = br.readLine();
//            maxLength = Math.max(maxLength, nums.length() - 1);
//            for (int j = 0; j < nums.length(); j++) {
//                List<Character> digits = digitsByPosition.getOrDefault(j, new ArrayList<>());
//                digits.add(nums.charAt(nums.length() - 1 - j));
//                digitsByPosition.put(j, digits);
//            }
//        }
//
//        for (int i = maxLength; i >= 0; i--) {
//            List<Character> digits = digitsByPosition.get(i);
//            Collections.sort(digits);
//            for (Character digit : digits) {
//                if (!selectedDigits.contains(digit) && K > 0) {
//                    selectedDigits.add(digit);
//                    K--;
//                }
//            }
//        }
//
//        Map<Integer, Character> result = new HashMap<>();
//        for (int i = 0; i <= maxLength; i++) {
//            List<Character> digits = digitsByPosition.get(i);
//            int sum = to10(result.getOrDefault(i, '0'));
//            for (Character digit : digits) {
//                char c = convertToZIfSelected(digit);
//                sum += to10(c);
//            }
//
//            int pos = i;
//            while (sum > 0) {
//                result.put(pos, to36(sum % 36));
//                sum = sum / 36;
//                pos++;
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = result.size() - 1; i >= 0; i--) {
//            sb.append(result.get(i));
//        }
//        System.out.println(sb);