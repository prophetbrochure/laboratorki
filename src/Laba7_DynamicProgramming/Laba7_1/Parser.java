package Laba7_DynamicProgramming.Laba7_1;

import java.util.*;

public class Parser {
    // Внутренний метод
    private static List<List<Integer>> parseFromStringList(Iterable<String> stringList) {
        List<List<Integer>> matrix = new ArrayList<>();

        for (String line : stringList) {
            String[] numbers = line.split("\\s+");

            List<Integer> matrixLine = new ArrayList<>();
            for (String p : numbers) {
                matrixLine.add(Integer.parseInt(p));
            }
            matrix.add(matrixLine);
        }
        return matrix;
    }


    public static List<List<Integer>> parse(Scanner scanner) {
        List<String> stringList = new ArrayList<>();

        while (true) {
            String string = scanner.nextLine();
            if (string.isBlank()) {
                break;
            }
            stringList.add(string);
        }

        return parseFromStringList(stringList);
    }

    public static List<List<Integer>> parse(List<String> stringList) {
        return parseFromStringList(stringList);
    }

    public static List<List<Integer>> parse(String singleString){
        return parseFromStringList(Arrays.asList(singleString.split("\\R")));
    }
}
