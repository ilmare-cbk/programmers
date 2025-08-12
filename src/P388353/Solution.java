package P388353;

/**
 * 지게차와 크레인
 */
public class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static boolean[][] contact;
    private static int N, M;
    private static char[][] storages;

    public int solution(String[] storage, String[] requests) {
        N = storage.length;
        M = storage[0].length();
        storages = new char[N][M];
        contact = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = storage[i];
            for (int j = 0; j < M; j++) {
                storages[i][j] = s.charAt(j);
            }
        }

        int answer = N * M;

        for (String request : requests) {
            boolean pick = request.length() == 1;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (!pick && request.charAt(0) == storages[r][c]) { // 크레인인 경우
                        answer--;
                        storages[r][c] = '0'; // 방문 체크
                    } else if (pick && request.charAt(0) == storages[r][c] && contactingOutside(r, c)) {
                        answer--;
                        storages[r][c] = '0'; // 방문 체크
                    }
                }
            }

            // 외부 연결 체크
            boolean[][] visited = new boolean[N][M];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (storages[r][c] == '0' && !visited[r][c] && !contact[r][c]) {
                        contact[r][c] = checkOutside(r, c, visited);
                    }
                }
            }
        }
        return answer;
    }

    private boolean checkOutside(int r, int c, boolean[][] visited) {
        if (contactingOutside(r, c)) {
            contact[r][c] = true;
            return true;
        }

        for (int[] direction : directions) {
            int dr = r + direction[0];
            int dc = c + direction[1];
            if (!visited[dr][dc] && storages[dr][dc] == '0' && !contact[r][c]) {
                visited[dr][dc] = true;
                contact[r][c] = checkOutside(dr, dc, visited);
            }
        }

        return contact[r][c];
    }

    private boolean contactingOutside(int r, int c) {
        for (int[] direction : directions) {
            int dr = r + direction[0];
            int dc = c + direction[1];
            if (!isValid(dr, dc) || contact[dr][dc]) {
                return true;
            }
        }
        return false;
    }

    private boolean isValid(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(
                solution.solution(
                        new String[]{"AAAA"},
                        new String[]{"A"}
                )
        );
    }
}
