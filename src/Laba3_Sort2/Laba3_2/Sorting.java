package Laba3_Sort2.Laba3_2;

import java.util.List;

// Этот интерфейс будет общим для всех остальных сортировок
interface Sorting<T extends Comparable<? super T>> {
    void sort(List<T> list);
}
