package advent.of.code.day4;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class Day4 {

    public int getOverlappingSections(String fileName, int partNumber) throws IOException {

        String[] testData = getData(fileName).split("\\r\\n");

        int count = 0;
        for (String data : testData) {

            String[] sections = data.split(",");
            String[] section1 = sections[0].split("-");
            String[] section2 = sections[1].split("-");

            int section1Start = Integer.parseInt(section1[0]);
            int section1End = Integer.parseInt(section1[1]);

            int section2Start = Integer.parseInt(section2[0]);
            int section2End = Integer.parseInt(section2[1]);

            switch (partNumber) {
                case 1: {
                    if ((section1Start <= section2Start && section1End >= section2End) || (section2Start <= section1Start && section2End >= section1End)) {
                        count++;
                    }
                    break;
                }
                case 2: {
                    if (section1End >= section2Start && section2End >= section1Start) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private String getData(String fileName) throws IOException {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
        return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
    }
}
