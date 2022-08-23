import com.sun.source.doctree.SeeTree;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


public class TaxesCalculatorTest {

    @BeforeAll
    public static void initAll() {
        System.out.println("TaxesCalculator tests started");
    }

    @BeforeEach
    public void init() {
        System.out.println("Test started");
    }

    @ParameterizedTest
    @MethodSource("source")
    public void testCalcSum(String input, int myTotal, int expected) {
        int result = TaxesCalculator.calcSum(input, myTotal);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> source() {
        return Stream.of(Arguments.of("-1", 5, 5), Arguments.of("1", 5, 6));
    }

    @ParameterizedTest
    @MethodSource("incomeAndExpensesSource")
    public void testCalcTaxIncomeMinusExpenses (int myIncomeTotal, int myExpensesTotal, double expected) {
        double result = TaxesCalculator.calcTaxIncomeMinusExpenses(myIncomeTotal, myExpensesTotal);

        assertEquals(result, expected);
    }

    public static Stream<Arguments> incomeAndExpensesSource() {
        return Stream.of(Arguments.of(50, 100, 0), Arguments.of(100, 50, 7.5));
    }

    @AfterEach
    public void finished() {
        System.out.println("Test completed");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("All TaxesCalculator tests completed");
    }
}
