package advent.of.code.day3;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

public class Day3 {

    private String[] testData;

    public int getPrioritiesSum(String fileName) throws IOException {

        testData = getData(fileName).split("\\r\\n");

        int prioritySum = 0;
        for (String rucksack : testData) {

            int halfLength = rucksack.length()/2;
            List<Character> rucksack1 = rucksack.substring(0, halfLength).chars().mapToObj(c -> (char) c).toList();
            List<Character> rucksack2 = rucksack.substring(halfLength).chars().mapToObj(c -> (char) c).toList();
            char overlap = rucksack1.stream()
                    .filter(rucksack2::contains)
                    .toList().get(0);

            int priority = getPriority(overlap);

            prioritySum += priority;
        }
        return prioritySum;
    }

    public int getBadges(String fileName) throws IOException {

        testData = getData(fileName).split("\\r\\n");

        int prioritySum = 0;
        for (int i = 0; i < testData.length - 2; i+=3) {

            List<Character> rucksack1 = getRucksack(i);
            List<Character> rucksack2 = getRucksack(i + 1);
            List<Character> rucksack3= getRucksack(i + 2);

            char overlap = rucksack1.stream()
                    .filter(rucksack2::contains)
                    .filter(rucksack3::contains).toList().get(0);
            int priority = getPriority(overlap);

            prioritySum += priority;
        }
        return prioritySum;
    }

    private List<Character> getRucksack(int i) {

        return testData[i].chars().mapToObj(c -> (char) c).toList();
    }

    private int getPriority(char overlap) {

        if (Character.isUpperCase(overlap)) {
            return (int) overlap - "A".toCharArray()[0] + 1 + 26;
        } else {
            return  (int) overlap - "a".toCharArray()[0] + 1;
        }
    }

    private String getData(String fileName) throws IOException {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
        return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
    }
}
