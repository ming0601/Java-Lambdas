package chapters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Chapter6Test {

    @Test
    public void testSequentialSumOfSquares() {
        int result = Chapter6.sequentialSumOfSquares(IntStream.of(
                1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 10010, 1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 10010,1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 10010,
                1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 10010, 1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 10010,1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 10010,
                1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 10010, 1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 10010,1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 10010
        ));
        Assertions.assertEquals(992613465, result);
    }

    @Test
    public void testParallelSumOfSquares() {
        int result = Chapter6.parallelSumOfSquares(IntStream.of(
                1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 10010, 1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 10010,1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 10010,
                1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 10010, 1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 10010,1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 10010,
                1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 10010, 1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 10010,1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 10010
        ));
        Assertions.assertEquals(992613465, result);
    }

    @Test
    public void testSequentialMultiplyThrough() {
        int result = Chapter6.sequentialMultiplyThrough(Arrays.asList(1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 10010));
        Assertions.assertEquals(1556328448, result);
    }

    @Test
    public void testParallelMultiplyThrough() {
        int result = Chapter6.parallelMultiplyThrough(Arrays.asList(1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 10010));
        Assertions.assertEquals(1556328448, result);
    }

    @Test
    public void testSlowSumOfSquares() {
        int result = Chapter6.slowSumOfSquares(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Assertions.assertEquals(385, result);
    }

    @Test
    public void testFastSumOfSquares() {
        int result = Chapter6.fastSumOfSquares(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Assertions.assertEquals(385, result);
    }
}
