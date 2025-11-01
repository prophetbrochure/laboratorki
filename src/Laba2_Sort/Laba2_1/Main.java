package Laba2_Sort.Laba2_1;

import java.util.Arrays;

public class Main {

    static void swap(double[] arr, int x, int y) {
        double temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    static void insertionsSort(double[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    static void insertionsSort2(double[] arr) {
        for (int i = 1; i < arr.length; i++) {
            double current = arr[i];

            for (int j = i; j > 0; j--) {
                if (current < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                } else {
                    arr[j] = current;
                    break;
                }
                if (j == 1) {
                    arr[0] = current;
                }
            }
        }
    }

    static void insertionsSort3 (double[] arr) {
        for (int i = 1; i < arr.length; i++) {
            double current = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }


    public static void main(String[] args) {
        double[] M = {1, 3, 5, 7, 9, 8, 6, 4, 2, 0};
        double[] N = Arrays.copyOf(M, M.length);
        double[] K = Arrays.copyOf(M, M.length);


        insertionsSort(M);
        System.out.println(Arrays.toString(M));

        insertionsSort2(N);
        System.out.println(Arrays.toString(N));

        insertionsSort3(K);
        System.out.println(Arrays.toString(K));
    }
}
