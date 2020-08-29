package chapters.chapter5;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chapter5 {
    private static Map<Integer,Long> calculatedValues = new HashMap<>();
    static {
        calculatedValues.put(0, 0L);
        calculatedValues.put(1, 1L);
    }
    // 2.a find the longest name
    public static Optional<String> longestName(Stream<String> names) {
        // with Collectors and maxBy
//        return names.collect(Collectors.maxBy(Comparator.comparing(string -> (long) string.length())));
        // requested change from IntelliJ
        return names.max(Comparator.comparing(string -> (long) string.length()));
    }

    // 2.b count the number of times each word appears
    public static Map<String, Long> numberOfAppearanceForEachName(Stream<String> names) {
        return names.collect(Collectors.groupingBy(name -> name, Collectors.counting()));
    }

    // 3 Efficiently calculate a Fibonacci sequence using just the computeIfAbsent method on a Map.
    public static long efficientFibonacci(int value) {
        // computeIfAbsent works with Java 8 but not anymore from Java 9:
        // The mapping function should not modify this map during computation
        // Exception is thrown here:
        // int mc = modCount;
        // V v = mappingFunction.apply(key);
        // if (mc != modCount) { throw new ConcurrentModificationException(); }
        // ConcurrentHashMap can not either be used: recursive update Exception
//        return calculatedValues.computeIfAbsent(value, n -> efficientFibonacci(n-2) + efficientFibonacci(n-1));

        if (!calculatedValues.containsKey(value)) {
            // value -2 is first calculated in order for value -1 to use memoized values, thus enhancing calculation speed
            calculatedValues.put(value, efficientFibonacci(value - 2) + (efficientFibonacci(value - 1)));
        }
        return calculatedValues.get(value);
    }
}
