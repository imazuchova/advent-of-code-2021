import advent.of.code.day4.Day4;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestDay4 {

    private Day4 day4;

    @BeforeEach
    void setUp() {

        day4 = new Day4();
    }

    @Test
    void  getOverlappingSections1() throws IOException {

        int result = day4.getOverlappingSections("TestData.txt", 1);
        System.out.println(result);
    }

    @Test
    void getOverlappingSections2() throws IOException {

        int result = day4.getOverlappingSections("TestData.txt", 2);
        System.out.println(result);
    }
}
