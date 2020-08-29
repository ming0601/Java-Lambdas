package chapters;

import chapters.chapter5.Chapter5;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class Chapter5Test {

    @Test
    public void testToGetTheLongestName_shouldReturnTheLongestName() {
        Stream<String> names = Stream.of(
                "John Lennon", "Paul McCartney", "George Harrison", "Ringo Starr", "Pete Best", "Stuart Sutcliffe");
        Optional<String> result = Chapter5.longestName(names);
        result.ifPresent(res -> Assertions.assertEquals("Stuart Sutcliffe", res));
    }

    @Test
    public void testToGetNumberOfAppearanceForEachName_shouldReturnAMapWithCorrectValues() {
        Stream<String> names = Stream.of("John", "Paul", "George", "John", "Paul", "John");
        Map<String, Long> expectedResults = new LinkedHashMap<>();
        expectedResults.put("John", 3L);
        expectedResults.put("Paul", 2L);
        expectedResults.put("George", 1L);
        Map<String, Long> results = Chapter5.numberOfAppearanceForEachName(names);
        Assertions.assertEquals(expectedResults, results);
    }

    @Test
    public void testEfficientFibonacci_shouldReturnEfficientlyCalculatedValue() {
        long result = Chapter5.efficientFibonacci(50);
        Assertions.assertEquals(12586269025L, result);
        long result1 = Chapter5.efficientFibonacci(16);
        Assertions.assertEquals(987L, result1);
    }
}
