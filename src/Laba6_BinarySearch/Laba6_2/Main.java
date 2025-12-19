package Laba6_BinarySearch.Laba6_2;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    static boolean norm(int n, int h, int w, int squareLen) {
        if (squareLen < 0) {
            return false;
        }
        int width = squareLen / w;
        int height = squareLen / h;
        return height * width >= n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        System.out.println("Введите ширину, высоту и количество дипломов");

        int w = sc.nextInt(), h = sc.nextInt(), n = sc.nextInt();
        if (n < 0 || h <= 0 || w <= 0) {
            System.out.println("bro\uD83D\uDC80\uD83D\uDE2D\uD83E\uDD40\uD83D\uDE4F");
            return;
        }

        int left = 0, right = Math.max(h, w) * n, middle = (left + right) / 2;

        while (!(norm(n, h, w, middle) && !norm(n, h, w, middle - 1))) {
            if (norm(n, h, w, middle)) {
                right = middle;
            } else {
                left = middle;
            }
            middle = (left + right) / 2;
        }

        System.out.println(middle);
    }
}