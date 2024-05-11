package 알람시계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] time = br.readLine().split(" ");
        int H = Integer.parseInt(time[0]);
        int M = Integer.parseInt(time[1]);
        if (M - 45 < 0) {
            if (H == 0) {
                H = 23;
            }
            else {
                H--;
            }
            M = 60 + M - 45;
        }
        else {
            M = M - 45;
        }
        System.out.println(H + " " + M);
    }
}
