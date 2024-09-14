package advent.of.code.day1;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class Day1 {

    public int getHighestCalories(String fileName) throws IOException {

        List<Integer> calorieSums = getCalorieSums(fileName);
        return calorieSums.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(() -> new IllegalStateException("No calorie data found"));
    }

    public int getTopThreeCalories(String fileName) throws IOException {

        List<Integer> calorieSums = getCalorieSums(fileName);
        return calorieSums.stream()
                .sorted((a, b) -> Integer.compare(b, a))  // Sort in descending order
                .limit(3)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private List<Integer> getCalorieSums(String fileName) throws IOException {

        String data = getData(fileName);
        return Arrays.stream(data.split("\\r\\n\\r\\n"))
                .map(this::sumCalories)
                .collect(Collectors.toList());
    }

    private int sumCalories(String calorieBlock) {

        return Arrays.stream(calorieBlock.split("\\r\\n"))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private String getData(String fileName) throws IOException {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
        return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
    }
}
