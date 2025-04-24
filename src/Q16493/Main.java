package Q16493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최대 페이지 수
 */
public class Main {
    private static int N, M;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M][2];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(read(N, 0));
    }

    private static int read(int days, int chapter) {
        if (chapter == M) return 0;

        // 안 읽는 경우
        int pages = read(days, chapter + 1);

        if (days >= arr[chapter][0]) {
            pages = Math.max(pages, read(days - arr[chapter][0], chapter + 1) + arr[chapter][1]);
        }

        return pages;
    }
}
