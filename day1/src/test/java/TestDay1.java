import advent.of.code.day1.Day1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestDay1 {

    private Day1 day1;

    @BeforeEach
    void setUp() {

        day1 = new Day1();
    }

    @Test
    void highestCalorieTest() throws IOException {

        int result = day1.getHighestCalories("TestDataSmall.txt");
        System.out.println(result);
    }

    @Test
    void highestTop3CalorieTest() throws IOException {

        int result = day1.getTopThreeCalories("TestData.txt");
        System.out.println(result);
    }
}
