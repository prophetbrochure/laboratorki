package Laba2_Sort.Laba2_2;


import java.util.Arrays;


public class Main {
    static void mergeSort(double[] arr) {
        if (arr.length <= 1) {
            return;
        }

        int mid = arr.length / 2;
        double[] left = Arrays.copyOfRange(arr, 0, mid);
        double[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);

        int leftIndex = 0, rightIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((rightIndex < right.length) && (leftIndex >= left.length || right[rightIndex] < left[leftIndex])) {
                arr[i] = right[rightIndex];
                rightIndex++;
            } else {
                arr[i] = left[leftIndex];
                leftIndex++;
            }
        }
    }



    static void mergeSort2(double[] arr, int start, int end) {  //end = размер массива, на 1 больше макс. индекса
        double[] buffer = new double[end - start];

        if (end - start <=1) {
            return;
        }

        int mid = (end + start) / 2;

        mergeSort2(arr, start, mid);
        mergeSort2(arr, mid, end);

        int leftIndex = start, rightIndex = mid;
        for (int i = 0; i < end - start; i++) {
            if ((rightIndex < end) && (leftIndex >= mid || arr[rightIndex] < arr[leftIndex])) {
                buffer[i] = arr[rightIndex];
                rightIndex++;
            } else {
                buffer[i] = arr[leftIndex];
                leftIndex++;
            }
        }
        System.arraycopy(buffer, 0, arr, start, end - start);
    }



    static void mergeSort3(double[] arr) {
        double[] buffer = new double[arr.length]; // создаём буфер один раз
        recursiveShit(arr, 0, arr.length, buffer);
    }
    static void recursiveShit(double[] arr, int start, int end, double[] buffer) {
        if (end - start <= 1) {
            return;
        }

        int mid = (start + end) / 2;

        recursiveShit(arr, start, mid, buffer);
        recursiveShit(arr, mid, end, buffer);

        int leftIndex = start, rightIndex = mid;
        for (int i = 0; i < end - start; i++) {
            if ((rightIndex < end) && (leftIndex >= mid || arr[rightIndex] < arr[leftIndex])) {
                buffer[i] = arr[rightIndex++];
            } else {
                buffer[i] = arr[leftIndex++];
            }
        }
        System.arraycopy(buffer, 0, arr, start,end-start);
    }



    public static void main(String[] args) {
        double[] M = {1, 3, 5, 7, 9, 8, 6, 4, 2, 0, 2};
        double[] N = Arrays.copyOf(M, M.length);
        double[] K = Arrays.copyOf(M, M.length);


        mergeSort(M);
        System.out.println(Arrays.toString(M));

        mergeSort2(N, 0, N.length);
        System.out.println(Arrays.toString(N));

        mergeSort3(K);
        System.out.println(Arrays.toString(K));
    }

}
