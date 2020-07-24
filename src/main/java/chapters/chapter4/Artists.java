package chapters.chapter4;

import models.Artist;

import java.util.List;
import java.util.Optional;

// Chapter 4, question 3
public class Artists {
    private List<Artist> artists;

    public Artists(List<Artist> artists) {
        this.artists = artists;
    }

    public Optional<Artist> getArtist(int index) {
        // Old code
//        if (index < 0 || index >= artists.size()) {
//            indexException(index);
//        }
//        return artists.get(index);

        // Refactored code with Optional
        if (index < 0 || index >= artists.size()) {
            return Optional.empty();
        }
        return Optional.of(artists.get(index));
    }

    public String getArtistName(int index) {
        // Old code
//        try {
//                Artist artist = getArtist(index);
//                return artist.getName();
//        } catch (IllegalArgumentException e) {
//            return "Unknown Artist";
//        }

        // New code with Optional and map
        Optional<Artist> artist = getArtist(index);
        return  artist.map(Artist::getName).orElse("Unknown Artist");
    }

    private void indexException(int index) {
        throw new IllegalArgumentException(index + " doesn't correspond to an Artist");
    }
}
