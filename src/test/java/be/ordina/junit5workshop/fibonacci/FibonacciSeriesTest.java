package be.ordina.junit5workshop.fibonacci;

import be.ordina.junit5workshop.fibonacci.FibonacciSeries;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;


class FibonacciSeriesTest {
    private FibonacciSeries fibonacciSeries = new FibonacciSeries();


    @Test
    void getNumberForNegativeNumbers() {
        assertThrows(IllegalArgumentException.class, () -> fibonacciSeries.getNumberForRank(-1), "I should not be smaller than 0");
    }

    @ParameterizedTest(name = "the number with rank {0} in the fibonacci series is {1}")
    @CsvSource({"0,0", "1,1", "2,1", "3,2", "4,3", "5,5", "6,8", "7,13"})
    void getNumberForRank(int rank, long fibonacciNumber) {
        assertThat("the number for rank '" + rank + "' should be '" + fibonacciNumber + "'",
                fibonacciSeries.getNumberForRank(rank), is(fibonacciNumber));
    }


    @ParameterizedTest
    @ValueSource(longs = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597})
    void isPartOfTheSequence(long number) {
        assertTrue(fibonacciSeries.isPartOfSequence(number));
    }

    @TestFactory
    Stream<DynamicTest> isNotPartOfTheSequence() {
        List<Long> first18FibonacciNumbers = Lists.newArrayList(0L, 1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L, 55L, 89L, 144L, 233L, 377L, 610L, 987L, 1597L);
        return LongStream.range(0, 1600)
                .filter(l -> !first18FibonacciNumbers.contains(l))
                .mapToObj((l) -> DynamicTest.dynamicTest("Number '" + l + "' is not part of the fibonacci sequence",
                        () -> assertFalse(fibonacciSeries.isPartOfSequence(l))));
    }

}