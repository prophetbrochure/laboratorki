package Laba3_Sort2.Laba3_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void CountingSort(List<Integer> list) {
        int[] array = new int[128];

        for (Integer i : list) {
            try {
                array[i]++;
            } catch (Exception e) {
                System.out.println("Элемент списка не подходит для сортировки подсчётом");
                return;
            }
        }

        int listIndex = 0;
        for (int arrayIndex = 0; arrayIndex < 128; arrayIndex++) {
            for (int selectedNumberIndex = 0; selectedNumberIndex < array[arrayIndex]; selectedNumberIndex++) {
                list.set(listIndex, arrayIndex);
                listIndex++;
            }
        }
    }

//    public <T extends Number> void CountingSort2(List<T> list) {
//        int[] array = new int[128];
//
//        for (T i : list) {
//            try {
//                array[i.intValue()]++;
//            } catch (Exception e) {
//                System.out.println("Элемент списка не подходит для сортировки подсчётом");
//                return;
//            }
//        }
//
//        int listIndex = 0;
//        for (int arrayIndex = 0; arrayIndex < 128; arrayIndex++) {
//            for (int selectedNumberIndex = 0; selectedNumberIndex < array[arrayIndex]; selectedNumberIndex++) {
//                list.set(listIndex, T.valueOf(arrayIndex));
//                listIndex++;
//            }
//        }
//    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9, 8, 6, 4, 2, 0, 2, 1, 3, 5, 7, 9, 8, 6, 4, 2, 0, 2, 1, 3, 5, 7, 9, 8, 6, 4, 2, 0, 2));
        System.out.println("Изначальный список: \n" + list);

        CountingSort(list);
        System.out.println("Отсортированный список: \n" + list);

    }
}


