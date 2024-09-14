package advent.of.code.day2;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;

public class Day2 {

    private static final Map<String, Integer> SCORE_MAP = Map.of("X", 1, "Y", 2, "Z", 3);

    private static final Map<String, String> DRAW_MAP = Map.of("A", "X", "B", "Y", "C", "Z");

    private static final Map<String, String> WIN_MAP = Map.of("A", "Y", "B", "Z", "C", "X");

    private static final Map<String, String> LOOSE_MAP = Map.of("A", "Z", "B", "X", "C", "Y");

    public int getScore(String fileName) throws IOException {

        String[] testData = getData(fileName).split("\\r\\n");

        int score = 0;
        for (String data : testData) {

            String[] pair = data.split(" ");
            score += SCORE_MAP.get(pair[1]);
            if (data.equals("A Y") || data.equals("B Z") || data.equals("C X")) {
                score += 6;
            } else if (data.equals("A X") || data.equals("B Y") || data.equals("C Z")) {
                score += 3;
            }
        }

        return score;
    }

    public int getScore2(String fileName) throws IOException {

        String[] testData = getData(fileName).split("\\r\\n");

        int score = 0;
        for (String data : testData) {

            String[] pair = data.split(" ");
            String opponent = pair[0];
            String result = pair[1];
            String myDraw = null;

            switch (result) {
                case "X":
                    myDraw = LOOSE_MAP.get(opponent);
                    break;
                case "Y": {
                    myDraw = DRAW_MAP.get(opponent);
                    score += 3;
                }
                break;
                case "Z": {
                    myDraw = WIN_MAP.get(opponent);
                    score += 6;
                }
            }
            score += SCORE_MAP.get(myDraw);
        }

        return score;
    }

    private String getData(String fileName) throws IOException {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
        return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
    }
}
