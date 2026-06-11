/*
Топологическая сортировка.

Напишите алгоритм топологической сортировки графа. Имейте ввиду, что нужно проверить, есть в графе циклы или нет.
Можете реализовать любым способом: через поиск в глубину или через счетчики.

Пример
Вход:
6
0 1
0 2
1 3
2 3
4 5
Выход:
0 1 2 3
4 5

*/

package Laba10_Graphs.Laba10_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество вершин графа");
        //  Число вершин
        int verticesCount = Integer.parseInt(scanner.nextLine());

        //  Матрица смежности.
        //  Для каждой вершины содержит список вершин, смежных с ней.
        List<List<Integer>> adjacencyList = new ArrayList<>(verticesCount);
        for (int i = 0; i < verticesCount; i++) {
            adjacencyList.add(new ArrayList<>());
        }


        System.out.println("Введите пары вершин, соединённых рёбрами.");
        while (true) {
            String s = scanner.nextLine();
            if (s.isEmpty()) {
                break;
            } else {
                String[] sl = s.split(" ");
                int a = Integer.parseInt(sl[0]);
                int b = Integer.parseInt(sl[1]);

                adjacencyList.get(a).add(b);
            }
        }

        TopologicalSort topologicalSort = new TopologicalSort(adjacencyList);
        System.out.println("Топологически отсортированный граф: " + topologicalSort.getSortedList());
    }
}