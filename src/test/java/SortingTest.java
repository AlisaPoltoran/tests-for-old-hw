import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortingTest {
    @BeforeAll
    public static void initAll() {
        System.out.println("Sorting tests started");
    }

    @BeforeEach
    public void init() {
        System.out.println("Test started");
    }

    @Test
    public void mergeTest() {
        int[] team1 = {108, 96, 87, 84, 73, 12, 10, 9, 5, 1};
        int[] team2 = {98, 77, 66, 15, 13, 11, 8, 6, 3, 2};
        int[] expected = {108, 98, 96, 87, 84, 77, 73, 66, 15, 13};

        int[] result = Sorting.merge(team1, team2);

        assertArrayEquals(result, expected);

    }

    @Test
    public void formNationalTeam() {
        int[][] teams = {
                {45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
                {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},
                {51, 30, 10, 9, 8, 7, 6, 5, 2, 1},
        };
        int[] expected = {51, 45, 31, 31, 30, 24, 22, 20, 18, 17};

        int[] result = Sorting.formNationalTeam(teams);

        assertArrayEquals(result, expected);

    }



    @AfterEach
    public void finished() {
        System.out.println("Test completed");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("All Sorting tests completed");
    }
}
