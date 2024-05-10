package 나머지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        Set<Integer> reminder = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            n = Integer.parseInt(br.readLine());
            reminder.add(n % 42);
        }

        System.out.println(reminder.size());
    }
}
