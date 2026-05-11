/*
Дана последовательность чисел A=[a_1,a_2,...,a_n]. Нужно найти минимум M(i,j)
чисел на отрезке от i до j: M(i,j)= min(a_k), где i <= k < j

Используйте структуру данных дерево отрезков. Поиск минимума должен быть O(log(n))
 */

package Laba8_RangeQueries.Laba8_2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        int[] array = {1, 4, 3, -6, 2, 6, -8, 2, 3, 5};
        int i = 0, j = 9;

        System.out.println("Изначальный массив:" + Arrays.toString(array));
        System.out.println("Отрезок: от " + i + "до" + j);




    }
}
