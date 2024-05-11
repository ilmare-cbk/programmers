package ACM호텔;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            String[] data = br.readLine().split(" ");
            int H = Integer.parseInt(data[0]);
            int N = Integer.parseInt(data[2]);
            int y = (N % H) * 100;
            int x = (N / H) + 1;
            if (N % H == 0) {
                y = H * 100;
                x = N / H;
            }
            System.out.println(y + x);
            T--;
        }
    }
}
