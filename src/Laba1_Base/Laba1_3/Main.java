package Laba1_Base.Laba1_3;

import java.util.Arrays;

public class Main {
    static boolean hasCopies(double[] arr) {
        double[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.parallelSort(copy);  //n*log(n)
        for (int i = 0; i < copy.length - 1; i++) {    //n
            if (copy[i] == copy[i + 1]) {
                return true;
            }
        }
        return false;   // Итого: 2n*log(n)
    }

    public static void main(String[] args) {
        double[] M = {1, 3, 5, 7, 9, 8, 6, 4, 2, 0};



        System.out.println(hasCopies(M));
    }
}
