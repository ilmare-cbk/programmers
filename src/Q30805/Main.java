package Q30805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 사전 순 최대 공통 부분 수열
 */
public class Main {
    private static int N;
    private static int[] n;
    private static int M;
    private static int[] m;
    private static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer n_st = new StringTokenizer(br.readLine());
        n = new int[N];
        for (int i = 0; i < n.length; i++) {
            n[i] = Integer.parseInt(n_st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        StringTokenizer m_st = new StringTokenizer(br.readLine());
        m = new int[M];
        for (int i = 0; i < m.length; i++) {
            m[i] = Integer.parseInt(m_st.nextToken());
        }

        find();

        StringBuilder sb = new StringBuilder();
        sb.append(answer.size());
        if (!answer.isEmpty()) {
            sb.append(System.lineSeparator());
            for (Integer integer : answer) {
                sb.append(integer).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static void find() {
        int n_idx = 0;
        int m_idx = 0;
        int max_n_idx = 0;
        int max_m_idx = 0;

        while (n_idx < N && m_idx < M) {
            int result = 0;
            for (int i = n_idx; i < N; i++) {
                for (int j = m_idx; j < M; j++) {
                    if (n[i] == m[j] && n[i] > result) {
                        result = n[i];
                        max_n_idx = i;
                        max_m_idx = j;
                    }
                }
            }
            if (result != 0) {
                answer.add(result);
                n_idx = max_n_idx + 1;
                m_idx = max_m_idx + 1;
            } else {
                break;
            }
        }
    }
}
/*
5
2 2 2 2 2
5
1 2 1 1 1
1
2

9
5 4 3 1 5 3 7 5 5
8
5 7 2 1 3 5 4 3
2
7 5
 */