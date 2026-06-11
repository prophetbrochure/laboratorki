package Laba10_Graphs.Laba10_2;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Топологическая сортировка с использованием обхода в глубину.
 * Принцип: обходим в глубину, затем разворачиваем результат.
 * Если в процессе обхода наткнулись на уже посещённую вершину - есть цикл, сортировка невозможна.
 *
 * Каждая вершина может быть одной из 3х видов:
 *      Белая - вершина не была посещена.
 *      Серая - в стеке рекурсии DFS ().
 *      Чёрная - вершина была посещена.
 * </pre>
 */
public class TopologicalSort {
    private final List<List<Integer>> adjacencyList;

    public TopologicalSort(List<List<Integer>> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    final int WHITE = 0, GRAY = 1, BLACK = 2;

    private void sort() {
        List<Integer> answer = new ArrayList<>(adjacencyList.size());
        int[] color = new int[adjacencyList.size()];

        for (int i = 0; i < adjacencyList.size(); i++) {
            if (color[i] == WHITE) {
                dfs(i, color, answer);
            }
        }
        sortedList = answer.reversed();
    }

    // depth-first search (Обход в глубину)
    private void dfs(int currentVertex, int[] color, List<Integer> answer) {
        color[currentVertex] = GRAY;

        for (Integer i : adjacencyList.get(currentVertex)) {
            if (color[i] == GRAY) {
                throw new IllegalArgumentException("Невозможно произвести топологическую сортировку циклического графа");
            }
            if (color[i] == WHITE) {
                dfs(i, color, answer);
            }
        }

        color[currentVertex] = BLACK;
        answer.add(currentVertex);
    }


    private List<Integer> sortedList;

    public List<Integer> getSortedList() {
        if (sortedList == null) {
            sort();
        }
        return sortedList;
    }
}
