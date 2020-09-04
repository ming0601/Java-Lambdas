package chapters.chapter9;

import models.Artist;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * The first part of this exercise is to refactor the blocking return code to use a callback interface.
 * In this case, we’ll be using a Consumer<Boolean>. Remember that Consumer is a functional interface that ships with
 * the JVM that accepts a value and returns void. Your mission, should you choose to accept it, is to alter
 * BlockingArtistAnalyzer so that it implements ArtistAnalyzer
 */
public class CallbackArtistAnalyzer implements ArtistAnalyzer {

    private final Function<String, Artist> artistLookupService;

    public CallbackArtistAnalyzer(Function<String, Artist> artistLookupService) {
        this.artistLookupService = artistLookupService;
    }

    @Override
    public void isLargerGroup(String artistName, String otherArtistName, Consumer<Boolean> handler) {
        boolean isLarger = getNumberOfMembers(artistName) > getNumberOfMembers(otherArtistName);
        handler.accept(isLarger);
    }

    private long getNumberOfMembers(String artistName) {
        return artistLookupService.apply(artistName)
                .getMembers()
                .count();
    }
}
