package chapters;

import models.Album;
import models.Artist;
import models.Track;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Chapter3Test {

    @Test
    public void testQuestion1a_shouldAddAllStreamIntegerValues() {
        Stream<Integer> ints = Stream.of(1, 2, 3, 4);
        int result = Chapter3.addUp(ints);
        Assertions.assertEquals(10, result);
    }

    @Test
    public void testQuestion1b_shouldReturnListOfStringsWithNameAndOrigin() {
        List<String> result = Chapter3.getNameAndOriginFromArtists(generateArtists(4));
        Assertions.assertEquals(Arrays.asList(
                "Artist 0, Origin 0", "Artist 1, Origin 1", "Artist 2, Origin 2", "Artist 3, Origin 3"),
                result);
    }

    @Test
    public void testQuestion1c_shouldReturnAlbumsWithAtMost3Tracks() {
        Album album1 = new Album();
        album1.setName("Album 1");
        album1.setArtists(generateArtists(1));
        album1.setTracks(generateTracks(1));

        Album album2 = new Album();
        album2.setName("Album 2");
        album2.setArtists(generateArtists(2));
        album2.setTracks(generateTracks(10));

        List<Album> result = Chapter3.extractAlbumsWithAtMost3Tracks(Arrays.asList(album1, album2));
        Assertions.assertEquals(Collections.singletonList(album1), result);
    }

    @Test
    public void testQuestion2__shouldReturnMembersNumber() {
        List<Artist> artists = generateArtists(10);
        long result = Chapter3.convertExternalIterationToInternalIteration(artists);
        Assertions.assertEquals(20, result);
    }

    @Test
    public void testQuestion6_shouldCountAllLowerCaseLetters() {
        String input = "Kotlin";
        long result = Chapter3.countLowerCaseLetterInString(input);
        Assertions.assertEquals(5, result);
    }

    @Test
    public void testQuestion7_shouldReturnLargestNbOfLowerCaseString() {
        List<String> inputs = new ArrayList<>();
        inputs.add("Kotlin");
        inputs.add("Java");
        inputs.add("Javascript");
        inputs.add("Python");

        Optional<String> result = Chapter3.findLargestNbOfLowerCaseLetterInListString(inputs);
        Assertions.assertEquals("Javascript", result.get());
    }

    @Test
    public void testCustomMap() {
        List<Artist> artists = generateArtists(5);
        List<String> expectedOriginValues = new ArrayList<>();
        expectedOriginValues.add("Origin 0");
        expectedOriginValues.add("Origin 1");
        expectedOriginValues.add("Origin 2");
        expectedOriginValues.add("Origin 3");
        expectedOriginValues.add("Origin 4");
        List<String> result = Chapter3.customMap(artists.stream(), Artist::getOrigin);
        Assertions.assertEquals(expectedOriginValues, result);
    }

    @Test
    public void testCustomFilter() {
        List<Artist> artists = generateArtists(3);
        List<Artist> result = Chapter3.customFilter(artists.stream(), artist -> artist.getName().equals("Artist 0"));
        Assertions.assertEquals(generateArtists(1).get(0).getName(), result.get(0).getName());
    }

    private List<Artist> generateArtists(int number) {
        List<Artist> artists = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            Artist artist = new Artist();
            artist.setName("Artist " + i);
            artist.setOrigin("Origin " + i);
            artist.setMembers(Stream.of(new Artist(), new Artist()));
            artists.add(artist);
        }
        return artists;
    }

    private List<Track> generateTracks(int number) {
        List<Track> tracks = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            Track track = new Track();
            track.setName("Track " + i);
            tracks.add(track);
        }
        return tracks;
    }
}
