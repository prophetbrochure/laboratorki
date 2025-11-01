package sortings;

import java.util.List;

public class InsertionSort1 implements Sortable<Double> {
    private void swap(List<Double> arr, int x, int y) {
        double temp = arr.get(x);
        arr.set(x, arr.get(y));
        arr.set(y, temp);
    }

    @Override
    public void sort(List<Double> nums) {
        for (int i = 1; i < nums.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (nums.get(j) < nums.get(j - 1)) {
                    swap(nums, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
}
