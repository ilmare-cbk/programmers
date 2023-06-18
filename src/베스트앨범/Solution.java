package 베스트앨범;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Songs songs = makeSongs(genres, plays);
        return songs.findSongsSortedByPlays();
    }

    private Songs makeSongs(String[] genres, int[] plays) {
        List<Song> songs = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            songs.add(new Song(i, genres[i], plays[i]));
        }

        return new Songs(songs);
    }

    private static class Song {
        private int id;
        private String genre;
        private int plays;

        public Song(int id, String genre, int plays) {
            this.id = id;
            this.genre = genre;
            this.plays = plays;
        }

        public int getId() {
            return id;
        }

        public String getGenre() {
            return genre;
        }

        public int getPlays() {
            return plays;
        }
    }

    private static class Songs {
        private List<Song> values;

        public Songs(List<Song> songs) {
            this.values = songs.stream()
                    .sorted(Comparator.comparing(Song::getPlays).reversed()
                            .thenComparing(Song::getId))
                    .collect(Collectors.toList());
        }

        public int[] findSongsSortedByPlays() {
            Map<String, List<Song>> songsByGenre = values.stream()
                    .collect(Collectors.groupingBy(Song::getGenre));

            List<String> genres = findGenresSortedByPlays(songsByGenre);

            List<Integer> ids = new ArrayList<>();

            for (String genre : genres) {
                List<Song> songs = songsByGenre.get(genre);
                for (int i = 0; i < songs.size(); i++) {
                    if (i > 1) {
                        break;
                    }
                    ids.add(songs.get(i).getId());
                }
            }

            return ids.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
        }

        private List<String> findGenresSortedByPlays(Map<String, List<Song>> songsByGenre) {
            Map<String, Integer> playsByGenre = new HashMap<>();

            for (Map.Entry<String, List<Song>> entry : songsByGenre.entrySet()) {
                playsByGenre.put(entry.getKey(),
                        entry.getValue().stream().map(Song::getPlays).reduce(0, Integer::sum));
            }

            return playsByGenre.entrySet()
                    .stream().sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
        }
    }

    public static void main(String[] args) {
        String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop"};
        int[] plays = new int[] {500, 600, 150, 800, 2500};

        Solution solution = new Solution();
        int[] answers = solution.solution(genres, plays);

        System.out.println(Arrays.toString(Arrays.stream(answers).toArray()));
    }
}
