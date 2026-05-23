package Laba7_DynamicProgramming.Laba7_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {
        String inputString = Files.readString(Path.of("src/Laba7_DynamicProgramming/Laba7_1/roguelike-input.csv"));

        List<List<Integer>> matrix = Parser.parse(inputString);

        System.out.println("Матрица:");
        matrix.forEach(System.out::println);

        PathFinder pathFinder = new PathFinder(matrix);
        pathFinder.calculatePaths();

        System.out.println("Список путей:");
        pathFinder.getPathList().forEach(System.out::println);

        System.out.println("Самый выгодный путь: " + pathFinder.getBestPath());

        


    }
}
