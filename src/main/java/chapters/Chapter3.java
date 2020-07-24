package chapters;

import models.Album;
import models.Artist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chapter3 {
    // Question 1
    // a:
    public static int addUp(Stream<Integer> numbers) {
//        return numbers.reduce(0, (acc, number) -> acc + number);
        return numbers.reduce(0, Integer::sum);
    }

    // b:
    public static List<String> getNameAndOriginFromArtists(List<Artist> artists) {
        return artists.stream()
                .map(artist -> artist.getName() + ", " + artist.getOrigin())
                .collect(Collectors.toList());
    }

    // c:
    public static List<Album> extractAlbumsWithAtMost3Tracks(List<Album> albums) {
        return albums.stream()
                .filter(album -> album.getTracks().size() <= 3)
                .collect(Collectors.toList());
    }

    // Question 2
    public static long convertExternalIterationToInternalIteration(List<Artist> artists) {

        // function to convert
//        int totalMembers = 0;
//        for (Artist artist: artists) {
//            Stream<Artist> members = artist.getMembers();
//            totalMembers += members.count();
//        }

//        return artists.stream()
//                .map(artist -> artist.getMembers().count())
//                .reduce(0L, Long::sum)
//                .intValue();
        return artists.stream().flatMap(Artist::getMembers).count();
    }

    // Question 3
    // Methods such as filter() that build up the Stream recipe but don't force a new value to be generated at the end are referred as lazy.
    // Methods such as count() that generate a final value out of the Stream sequence are called eager.

    // Question 4
    // Higher order function is a function that either takes a function as parameter or returns a function after its execution.

    // Question 5
    // x -> x + 1 => pure function, it only depends on the input parameters and has no side effects
    // which means it doesn't modify any state (variables) outside the function anywhere.
    // a: it is not a pure function because it modifies a variable (count) outside the function.

    // Question 6
    public static long countLowerCaseLetterInString(String input) {
        return input.chars().filter(Character::isLowerCase).count();
    }

    // Question 7
    public static Optional<String> findLargestNbOfLowerCaseLetterInListString(List<String> inputs) {
        return inputs.stream().max(Comparator.comparing(Chapter3::countLowerCaseLetterInString));
    }

    // Advanced Question 1: create map function with reducer and lambda expressions
    public static <I, O> List<O> customMap(Stream<I> input, Function<I, O> mapper) {
        return input.reduce(new ArrayList<>(),
                (acc, data) -> {
                    // We are copying data from acc to new list instance. It is very inefficient,
                    // but contract of Stream.reduce method requires that accumulator function does
                    // not mutate its arguments.
                    // Stream.collect method could be used to implement more efficient mutable reduction,
                    // but this exercise asks to use reduce method.
                    List<O> newAcc = new ArrayList<>(acc);
                    newAcc.add(mapper.apply(data));
                    return newAcc;
        }, (List<O> left, List<O> right) -> {
            // We are copying left to new list to avoid mutating it.
            List<O> newLeft = new ArrayList<>(left);
            newLeft.addAll(right);
            return newLeft;
        });
    }

    // Advanced Question 2: create filter function with reducer and lambda expressions
    public static <I> List<I> customFilter(Stream<I> stream, Predicate<I> predicate) {
        List<I> initial = new ArrayList<>();
        return stream.reduce(initial,
                (List<I> acc, I x) -> {
                    if (predicate.test(x)) {
                        // We are copying data from acc to new list instance. It is very inefficient,
                        // but contract of Stream.reduce method requires that accumulator function does
                        // not mutate its arguments.
                        // Stream.collect method could be used to implement more efficient mutable reduction,
                        // but this exercise asks to use reduce method explicitly.
                        List<I> newAcc = new ArrayList<>(acc);
                        newAcc.add(x);
                        return newAcc;
                    } else {
                        return acc;
                    }
                },
                Chapter3::combineLists);
    }

    private static <I> List<I> combineLists(List<I> left, List<I> right) {
        // We are copying left to new list to avoid mutating it.
        List<I> newLeft = new ArrayList<>(left);
        newLeft.addAll(right);
        return newLeft;
    }
}
