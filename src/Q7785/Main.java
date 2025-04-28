package Q7785;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 회사에 있는 사람
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String state = st.nextToken();
            if (state.equals("leave")) {
                map.remove(name);
            } else {
                map.put(name, state);
            }

        }

        String[] arr = new String[map.size()];
        int idx = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arr[idx] = entry.getKey();
            idx++;
        }
        Arrays.sort(arr, Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s).append(System.lineSeparator());
        }

        System.out.println(sb);
    }
}
