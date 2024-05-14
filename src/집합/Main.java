package 집합;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final int all = all();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int cur = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int number;
            switch (command) {
                case "add":
                    number = Integer.parseInt(st.nextToken());
                    cur = cur | (1 << 21 - number);
                    break;
                case "remove":
                    number = Integer.parseInt(st.nextToken());
                    cur = cur & ~(1 << 21 - number);
                    break;
                case "check":
                    number = Integer.parseInt(st.nextToken());
                    int checkNumber = 1 << 21 - number;
                    if (checkNumber == (cur & checkNumber)) {
                        bw.write(1 + System.lineSeparator());
                    } else {
                        bw.write(0 + System.lineSeparator());
                    }
                    break;
                case "toggle":
                    number = Integer.parseInt(st.nextToken());
                    cur = cur ^ (1 << 21 - number);
                    break;
                case "all":
                    cur = cur | all;
                    break;
                case "empty":
                    cur = 0;
                    break;
            }
        }
        bw.flush();
        bw.close();
    }

    private static int all() {
        int b = 0;
        for (int i = 1; i <= 20; i++) {
            b = b | (1 << i);
        }
        return b;
    }
}
