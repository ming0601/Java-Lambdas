package chapters.chapter9;

import models.Artist;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Now that we have an API that fits into the callback model,
 * we can remove the need for both of the blocking lookups to happen at the same time.
 * You should refactor the isLargerGroup method so that they can operate concurrently using the Completable Future class.
 */
public class CompletableFutureArtistAnalyzer implements ArtistAnalyzer {

    private final Function<String, Artist> artistLookupService;

    public CompletableFutureArtistAnalyzer(Function<String, Artist> artistLookupService) {
        this.artistLookupService = artistLookupService;
    }

    @Override
    public void isLargerGroup(String artistName, String otherArtistName, Consumer<Boolean> handler) {
        CompletableFuture<Long> otherArtistMemberCount = CompletableFuture.supplyAsync(() -> getNumberOfMembers(otherArtistName));

        CompletableFuture<Long> artistMemberCount = CompletableFuture.completedFuture(getNumberOfMembers(artistName));

        artistMemberCount.thenCombine(otherArtistMemberCount, (count, otherCount) -> count > otherCount)
                .thenAccept(handler::accept);
    }

    private long getNumberOfMembers(String artistName) {
        return artistLookupService.apply(artistName)
                .getMembers()
                .count();
    }
}
