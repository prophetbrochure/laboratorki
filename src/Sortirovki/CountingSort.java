package Sortirovki;

import java.util.List;

public class CountingSort implements Sorting<Integer> {
    private int maxNumbers = 128;

    public CountingSort() {
    }

    public CountingSort(int maxNumbers) {
        this.maxNumbers = maxNumbers;
    }

    @Override
    public void sort(List<Integer> list) {
        int[] array = new int[maxNumbers];

        for (Integer i : list) {
            try {
                array[i]++;
            } catch (Exception e) {
                System.out.println("Элемент списка не подходит для сортировки подсчётом");
                return;
            }
        }

        int listIndex = 0;
        for (int arrayIndex = 0; arrayIndex < maxNumbers; arrayIndex++) {
            for (int selectedNumberIndex = 0; selectedNumberIndex < array[arrayIndex]; selectedNumberIndex++) {
                list.set(listIndex, arrayIndex);
                listIndex++;
            }
        }
    }
}
