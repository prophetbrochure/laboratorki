package sortings;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Double> nums = Arrays.asList(1D, 3D, 5D, 7D, 9D, 8D, 6D, 4D, 2D, 0D);

        Sortable<Double> insertion = new InsertionSort1();


        insertion.sort(nums);
        System.out.println(nums);
    }
}
