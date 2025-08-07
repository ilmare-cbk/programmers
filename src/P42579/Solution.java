package P42579;

import java.util.*;

/**
 * 베스트앨범
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(
                new String[]{"a", "a", "a", "b", "b", "c"},
                new int[]{1, 2, 3, 4, 5, 6}
        )));
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Genre> genreMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String g = genres[i];
            int p = plays[i];
            Genre genre = genreMap.getOrDefault(g, new Genre(new ArrayList<>()));
            genre.addSong(new Song(i, p));
            genreMap.put(g, genre);
        }

        List<Integer> answer = new ArrayList<>();
        genreMap.values()
                .stream()
                .sorted()
                .forEach(it -> answer.addAll(it.getBestSongs()));

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static class Genre implements Comparable<Genre> {
        int totalPlanCnt;
        List<Song> songs;

        public Genre(List<Song> songs) {
            this.songs = songs;
            this.totalPlanCnt = songs.stream()
                    .map(it -> it.playCnt)
                    .reduce(0, Integer::sum);
        }

        @Override
        public int compareTo(Genre o) {
            return o.totalPlanCnt - this.totalPlanCnt;
        }

        public void addSong(Song song) {
            this.songs.add(song);
            this.totalPlanCnt += song.playCnt;
        }

        public List<Integer> getBestSongs() {
            Collections.sort(this.songs);
            List<Integer> bestSongs = new ArrayList<>();
            for (Song song : this.songs) {
                if (bestSongs.size() == 2) break;
                bestSongs.add(song.id);
            }
            return bestSongs;
        }
    }

    private static class Song implements Comparable<Song> {
        int id;
        int playCnt;

        public Song(int id, int playCnt) {
            this.id = id;
            this.playCnt = playCnt;
        }

        @Override
        public int compareTo(Song o) {
            if (this.playCnt != o.playCnt) return o.playCnt - this.playCnt;
            return this.id - o.id;
        }
    }
}
