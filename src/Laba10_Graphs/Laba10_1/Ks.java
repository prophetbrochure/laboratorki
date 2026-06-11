package Laba10_Graphs.Laba10_1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Ks от слова Komponenta Svyaznosti
 */
public class Ks {
    private final List<List<Integer>> adjacencyList;

    private Integer ksCount;
    private List<List<Integer>> ksList;

    public Ks(List<List<Integer>> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }


    private void calculateKsList() {
        HashSet<Integer> alreadyVisited = new HashSet<>(adjacencyList.size());
        ksList = new ArrayList<>();

        for (int i = 0; i < adjacencyList.size(); i++) {
            if (alreadyVisited.contains(i)) {
                continue;
            } else {
                List<Integer> currentKs = new ArrayList<>();
                ksList.add(currentKs);

                addAdjacentVertices(i, currentKs, alreadyVisited);
            }
        }

        ksCount = ksList.size();
    }

    /**
     * Добавляет все смежные вершины в компоненту связности
     */
    void addAdjacentVertices(Integer currentVertex, List<Integer> currentKs, HashSet<Integer> alreadyVisited) {
        if (alreadyVisited.contains(currentVertex)) {
            return;
        } else {
            alreadyVisited.add(currentVertex);
            currentKs.add(currentVertex);
            for (Integer i : adjacencyList.get(currentVertex)) {
                addAdjacentVertices(i, currentKs, alreadyVisited);
            }
        }
    }


    public Integer getKsCount() {
        if (ksCount == null) {
            calculateKsList();
        }
        return ksCount;
    }

    public List<List<Integer>> getKsList() {
        if (ksList == null) {
            calculateKsList();
        }
        return ksList;
    }
}
