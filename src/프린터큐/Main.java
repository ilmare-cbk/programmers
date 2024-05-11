package 프린터큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            String[] docs = br.readLine().split(" ");
            int targetId = Integer.parseInt(docs[1]);
            String[] priorities = br.readLine().split(" ");
            Queue<Document> d = new LinkedList<>();
            for (int i = 0; i < priorities.length; i++) {
                d.add(new Document(i, Integer.parseInt(priorities[i])));
            }
            List<Document> sortedPriorities = d.stream()
                    .sorted(Comparator.comparing(Document::getPriority))
                    .collect(Collectors.toList());
            int count = 0;
            while (!d.isEmpty()) {
                if (d.peek().getPriority() == sortedPriorities.get(sortedPriorities.size() - 1).getPriority()) {
                    count++;
                    Document document = d.poll();
                    int id = document.getId();
                    sortedPriorities.remove(document);
                    if (id == targetId) {
                        System.out.println(count);
                        break;
                    }
                }
                else {
                    d.add(d.poll());
                }
            }
            T--;
        }
    }

    private static class Document {
        private int id;
        private int priority;

        public Document(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }

        public int getId() {
            return id;
        }

        public int getPriority() {
            return priority;
        }
    }
}
