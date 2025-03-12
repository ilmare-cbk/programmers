package Q9019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * DSLR
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        char[] commands = {'D', 'S', 'L', 'R'};

        while (T-- > 0) {
            Queue<Integer> queue = new LinkedList<>();
            String[] command = new String[10000];
            boolean[] visited = new boolean[10000];
            String[] data = br.readLine().split(" ");
            int s = Integer.parseInt(data[0]);
            int d = Integer.parseInt(data[1]);

            queue.add(s);
            visited[s] = true;
            command[s] = "";

            while (!queue.isEmpty()) {
                Integer number = queue.poll();

                if (number == d) {
                    sb.append(command[number]).append(System.lineSeparator());
                    break;
                }

                for (char c : commands) {
                    int register = getRegister(c, number);
                    if (!visited[register]) {
                        command[register] = command[number] + c;
                        visited[register] = true;
                        queue.add(register);
                    }
                }
            }
        }

        System.out.println(sb);
    }

    private static int getRegister(char command, Integer number) {
        if (command == 'D') {
            return (2 * number) % 10000;
        } else if (command == 'S') {
            return number.equals(0) ? 9999 : number - 1;
        } else if (command == 'L') {
            int r = number % 1000;
            return (r * 10) + (number / 1000);
        } else {
            int d4 = number % 10;
            return ((number - d4) / 10) + d4 * 1000;
        }
    }
}
