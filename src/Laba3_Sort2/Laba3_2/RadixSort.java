package Laba3_Sort2.Laba3_2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RadixSort implements Sorting<BigInteger> {
    @Override
    public void sort(List<BigInteger> nums) {
        for (int i = 0; i < 20; i++) {
            countingSort(nums, i);
        }
    }

    private int getDigit(BigInteger x, int razryad) {
        BigInteger ten = BigInteger.TEN;
        return x.divide(ten.pow(razryad)).mod(ten).intValue();
    }

    private void countingSort(List<BigInteger> array, int razryad) {
        List<List<BigInteger>> countArray = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            countArray.add(new LinkedList<>());
        }

        for (BigInteger i : array) {
            countArray.get(getDigit(i, razryad)).add(i);
        }

        int listIndex = 0;
        for (List<BigInteger> i : countArray) {
            for (BigInteger j : i) {
                array.set(listIndex++, j);
            }
        }
    }
}
