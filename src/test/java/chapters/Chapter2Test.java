package chapters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Calendar;

public class Chapter2Test {
    @Test
    public void testQuestion2_shouldReturnRightFormat() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 1970);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        String result = Chapter2.formatter.get().getFormat().format(calendar.getTime());
        Assertions.assertEquals("01-Jan-1970", result);
    }
}
