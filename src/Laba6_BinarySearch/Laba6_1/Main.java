package Laba6_BinarySearch.Laba6_1;

import java.util.Arrays;
import java.util.List;

public class Main {
    static Integer find(List<Integer> nums, Integer target) {
        int left = 0;
        int right = nums.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums.get(mid).equals(target)) {
                return nums.get(mid);
            } else if (target < nums.get(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        if (right < 0) {
            return (nums.getFirst());
        } else if (left > nums.size() - 1) {
            return (nums.getLast());
        } else {
            int differentRight = target - nums.get(right);
            int differentLeft = nums.get(left) - target;
            if (differentRight <= differentLeft) {
                return (nums.get(right));
            } else {
                return (nums.get(left));
            }
        }
    }


    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 4, 8, 10, 14, 17, 20);
        System.out.println("Список: " + Arrays.toString(numbers.toArray()));

        System.out.println("Ближайшее число к числу " + "0: " + find(numbers, 0));
        System.out.println("Ближайшее число к числу " + "10: " + find(numbers, 10));
        System.out.println("Ближайшее число к числу " + "13: " + find(numbers, 13));
        System.out.println("Ближайшее число к числу " + "25: " + find(numbers, 25));
    }
}
