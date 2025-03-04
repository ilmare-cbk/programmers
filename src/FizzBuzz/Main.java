package FizzBuzz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = new String[3];
        input[0] = br.readLine();
        input[1] = br.readLine();
        input[2] = br.readLine();

        String answer = "";
        for (int i = 0; i < input.length; i++) {
            if (isNumber(input[i])) {
                answer = fizzBuzz(Integer.parseInt(input[i]) + 3 - i);
                break;
            }
        }

        System.out.println(answer);
    }

    private static boolean isNumber(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private static String fizzBuzz(int n) {
        if (n % 3 == 0 && n % 5 == 0) {
            return "FizzBuzz";
        } else if (n % 3 == 0) {
            return "Fizz";
        } else if (n % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(n);
        }
    }
}
