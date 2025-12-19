package Laba8_RangeQueries.Laba8_1;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        int len;
        System.out.println("Введите число элементов в массиве");
        len = sc.nextInt();

        List<Integer> array = new ArrayList<>(len);
        System.out.println("Введите элементы массива");
        for (int i = 0; i < len; i++) {
            array.add(sc.nextInt());
        }

        List<Integer> sumArray = new ArrayList<>(len);
        sumArray.addFirst(array.getFirst());

        for (int i = 1; i < len; i++) {
            sumArray.add(sumArray.get(i-1) + array.get(i));
        }

        System.out.println("Введите отрезок, на котором нужно найти сумму");
        int left = sc.nextInt(), right = sc.nextInt();

        int result = sumArray.get(right) - (left == 0 ? 0 : sumArray.get(left - 1));



        System.out.print("Сумма чисел на отрезке от " + left + " до " + right + " равна " + result);


    }
}
//  Индексы:    0   1   2   3   4
//  Массив:     5   4   3   2   1
//  Суммы:      5   9   12  14  15