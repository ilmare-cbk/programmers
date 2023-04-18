package 바탕화면정리;

import java.util.Arrays;

public class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int h = 0; h < wallpaper.length; h++) {
            String[] rows = wallpaper[h].split("");
            for (int w = 0; w < rows.length; w++) {
                String file = rows[w];
                if (file.equals("#")) {
                    updateStartPosition(answer, h, w);
                    updateEndPosition(answer, h, w);
                }
            }
        }
        return answer;
    }

    private void updateEndPosition(int[] answer, int h, int w) {
        int endH = answer[2];
        int endW = answer[3];
        if (endH < h + 1) {
            answer[2] = h + 1;
        }
        if (endW < w + 1) {
            answer[3] = w + 1;
        }
    }

    private void updateStartPosition(int[] answer, int h, int w) {
        int startH = answer[0];
        int startW = answer[1];

        if (startH > h) {
            answer[0] = h;
        }
        if (startW > w) {
            answer[1] = w;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] wallpaper = new String[]{".#...", "..#..", "...#."};
//                new String[]{".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
        int[] answers = solution.solution(wallpaper);
        System.out.println(Arrays.toString(Arrays.stream(answers).toArray()));
    }
}
