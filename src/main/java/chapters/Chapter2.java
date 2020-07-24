package chapters;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;

public class Chapter2 {

    /**
     * Question 1:
     *  a.
     *  @FunctionalInterface
     *  public interface Function<T, R> {
     *     R apply(T var1);
     *  }
     * Answer: input = R, then pass into Function and return T using apply method
     *  b. What kind of lambda expressions might you use this functional interface for if you were writing a software calculator?
     *  Unary Operators, for example 'not'
     *  c. x -> x + 1;
     *
     * Question 2:
     *  a. See under
     *
     * Question 3:
     *  a. Yes
     *  b. Yes
     *  c. Would check(x -> x > 5) be inferred, given the following overloads for check?
     *  interface IntPred {
     *      boolean test(Integer value);
     *  }
     *  No - the lambda expression could be inferred as IntPred or Predicate<Integer> so the overload is ambiguous.
     */
    // Question 2
    public static final ThreadLocal<DateFormatter> formatter =
            ThreadLocal.withInitial(() -> new DateFormatter(new SimpleDateFormat("dd-MMM-yyyy")));
}
