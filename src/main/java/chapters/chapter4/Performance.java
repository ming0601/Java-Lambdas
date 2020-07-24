package chapters.chapter4;

import models.Artist;

import java.util.stream.Stream;

// Chapter 4, question 1
// add a method getAllMusicians() that returns a Stream of musicians that are performing
// in case of groups, any musicians that are members of those groups
public interface Performance {
    String getName();

    Stream<Artist> getMusicians();

    default Stream<Artist> getAllMusicians() {
        return  getMusicians().flatMap(artist -> Stream.concat(Stream.of(artist), artist.getMembers()));
    }
}

// Question 2:
// Based on the resolution rules described earlier, can you ever override equals or
// hashcode in a default method?
// No - they are defined on java.lang.Object, and 'class always wins.'
