package Laba6_BinarySearch.Laba6_3;

import java.util.Locale;
import java.util.Scanner;


public class Main {
    static double f(double x) {
        return Math.pow(x, 2) - x + Math.sqrt(x);
    }

    public static void main(String[] args) {
        double accuracy = 6;

        double delta = Math.pow(10, -accuracy);
        double left = 0.0, right = Double.MAX_VALUE, middle = (left + right) / 2.0;

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        System.out.println("Введите a");
        System.out.println("Программа выводит такое x, что x^2 - x + sqrt(x) = a с точностью до 6 знаков");

        double input = sc.nextDouble();
        if (input < 0) {
            System.out.println("Введённое число вне области значений функции");
            return;
        }

        while (Math.abs(f(middle) - input) >= delta) {
            if (f(middle) > input) {
                right = middle;
            } else {
                left = middle;
            }
            middle = (left + right) / 2.0;
        }

        middle *= Math.pow(10, accuracy);
        middle = Math.round(middle);    // Округляет только до целых
        middle *= Math.pow(10, -accuracy);

        System.out.println(middle);


    }
}
