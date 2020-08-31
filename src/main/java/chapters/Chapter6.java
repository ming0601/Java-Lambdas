package chapters;

import java.util.List;
import java.util.stream.IntStream;

public class Chapter6 {

    // 1. The code in Example 6-10 sequentially sums the squares of numbers in a Stream.
    // Sequentially summing the squares of numbers in a list...
    public static int sequentialSumOfSquares(IntStream range) {
        return range.map(x -> x * x).sum();
    }

    // ...Make it run in parallel using streams.
    public static int parallelSumOfSquares(IntStream range) {
        return range.parallel().map(x -> x * x).sum();
    }



    // 2. The code multiplies every number in a list together and multiplies the result by 5.
    // This works fine sequentially...
    public static int sequentialMultiplyThrough(List<Integer> linkedListOfNumbers) {
        return linkedListOfNumbers.stream().reduce(5, (acc, x) -> x * acc);
    }

    // ...But has a bug when running in parallel.
    // Make the code run in parallel using streams and fix the bug.
    public static int parallelMultiplyThrough(List<Integer> listOfNumbers) {
        return 5 * listOfNumbers.stream().parallel().reduce(1, (acc, x) -> x * acc);
    }



    // 3. The code calculates the sum of the squares of numbers in a list.

    // Using .map .reduce results in INTERMEDIATE speed in parallel stream and sequential for ArrayList
    // Slow implementation of summing the squares of numbers in a list...
    public static int slowSumOfSquares(List<Integer> arrayListOfNumbers) {
//        return arrayListOfNumbers.parallelStream().map(x -> x * x).reduce(0, (acc, x) -> acc + x);
        return arrayListOfNumbers.stream().map(x -> x * x).reduce(0, Integer::sum);
    }

    // Using .map .reduce results in SLOW speed in parallel stream and sequential for LinkedList
    public int slowSumOfSquaresWithLinkedList(List<Integer> linkedListOfNumbers) {
//        return linkedListOfNumbers.parallelStream().map(x -> x * x).reduce(0, Integer::sum);
        return linkedListOfNumbers.stream().map(x -> x * x).reduce(0, Integer::sum);
    }

    // ...Try to improve the performance of this code without degrading its quality.
    // Just make a couple of simple changes.
    // FAST speed with Arraylist + .mapToInt .sum
    public static int fastSumOfSquares(List<Integer> arrayListOfNumbers) {
        return arrayListOfNumbers.parallelStream().mapToInt(x -> x * x).sum();
    }

    public static int serialFastSumOfSquares(List<Integer> arrayListOfNumbers) {
        return arrayListOfNumbers.stream().mapToInt(x -> x * x).sum();
    }
}
