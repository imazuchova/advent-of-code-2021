import advent.of.code.day2.Day2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestDay2 {

    private Day2 day2;

    @BeforeEach
    void setUp() {

        day2 = new Day2();
    }

    @Test
    void getScoreTest() throws IOException {

        int result = day2.getScore("TestData.txt");
        System.out.println(result);
    }

    @Test
    void getScore2Test() throws IOException {

        int result = day2.getScore2("TestData.txt");
        System.out.println(result);
    }
}
