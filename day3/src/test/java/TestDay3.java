import advent.of.code.day3.Day3;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestDay3 {

    private Day3 day3;

    @BeforeEach
    void setUp() {

        day3 = new Day3();
    }

    @Test
    void  getPrioritiesSumTest() throws IOException {

        int result = day3.getPrioritiesSum("TestData.txt");
        System.out.println(result);
    }

    @Test
    void getBadgesTest() throws IOException {

        int result = day3.getBadges("TestData.txt");
        System.out.println(result);
    }
}
