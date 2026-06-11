/*
Компоненты связности

Напишите алгоритм, который находит все компоненты связности в графе.

Граф должен быть задан списком ребер.

Вход
В первой строке число N (0≤N≤1000) - количество вершин графа.
В следующих строках записаны ребра, как пары чисел через пробел 42 12: вершина 42 и 12 связаны ребром.

Несуществующих вершин в этих строках не будет.

Выход
На выходе
K
K строк для каждой компоненты связности. В каждой строке через пробел числа этой компоненты связности.

Пример:
Ввод:
10
8 1
1 0
0 2
1 4
3 6
3 7
7 9
Вывод:
0 1 4 8 2
5
6 3 7 9
 */


package Laba10_Graphs.Laba10_1;


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
                adjacencyList.get(b).add(a);
            }
        }

        Ks ks = new Ks(adjacencyList);
        System.out.println("Число компонент связности: " + ks.getKsCount());

        System.out.println("Компоненты связности:");
        ks.getKsList().forEach(System.out::println);
    }
}
