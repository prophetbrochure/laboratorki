package Sortirovki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MergeSort<T extends  Comparable<T>> implements Sorting<T> {
    @Override
    public void sort(List<T> list) {
//      T[] buffer не работает потому что нельзя создавать массив неизвестных типов.
//      List<T> buffer = new ArrayList<>(list.size()); - не работает, потому что хз почему, библиотеки неудобные,
//      ArrayList даже когда создаёт List из n элементов, не заполняет его,
//      поэтому нельзя просто написать buffer.set(i,x), т. к. i-того элемента не существует,
//      хотя вроде бы как список основан на массиве, и размер указан при создании, но всем похуй.
        List<T> buffer = new ArrayList<>(Collections.nCopies(list.size(), null));
        recursiveShit(list, 0, list.size(), buffer);
    }

    void recursiveShit(List<T> list, int start, int end, List<T> buffer) {
        if (end - start <= 1) {
            return;
        }

        int mid = (start + end) / 2;

        recursiveShit(list, start, mid, buffer);
        recursiveShit(list, mid, end, buffer);

        int leftIndex = start, rightIndex = mid;
        for (int i = 0; i < end - start; i++) {
            if ((rightIndex < end) && (leftIndex >= mid || list.get(rightIndex).compareTo(list.get(leftIndex)) < 0)) {
                buffer.set(i, list.get(rightIndex++));
            } else {
                buffer.set(i, list.get(leftIndex++));
            }
        }

        for (int i = 0; i < end - start; i++) {
            list.set(start + i, buffer.get(i));
        }
    }
}
