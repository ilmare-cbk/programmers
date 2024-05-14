package 패션왕신해빈;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            int n = Integer.parseInt(br.readLine());
            Map<String, List<String>> clothes = new HashMap<>();
            while (n > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cloth = st.nextToken();
                String type = st.nextToken();
                List<String> clothesOfType = clothes.getOrDefault(type, new ArrayList<>());
                clothesOfType.add(cloth);
                clothes.put(type, clothesOfType);
                n--;
            }
            int count = 1;
            for (Map.Entry<String, List<String>> entry : clothes.entrySet()) {
                count = count * (1 + entry.getValue().size());
            }
            bw.write(count - 1 + System.lineSeparator());
            T--;
        }
        bw.flush();
        bw.close();
    }
}
