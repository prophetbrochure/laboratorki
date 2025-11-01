package Laba1_Base.Laba1_2;

import java.util.Arrays;
import java.util.Objects;

public class Main {
    static int removeElements(Double[] arr, Double val) {
        int j = 0;

        for (int i = 0; i < arr.length; i++) {
            if (!Objects.equals(arr[i], val)) {
                arr[j] = arr[i];
                j++;
            }
        }

        for (int i = j; i < arr.length; i++) {
            arr[i] = null;
        }
        return j;
    }


    public static void main(String[] args) {

        Double[] M = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 5.0, 4.0, 3.0, 2.0, 1.0};

        System.out.println(removeElements(M, 4.0) + "    " + Arrays.toString(M));
        System.out.println(removeElements(M, 5.0) + "    " + Arrays.toString(M));


        



        // Ебучие блять обёртки. Какого хуя Double x = 4 не работает, нужно писать Double x = 4.0
        // Зачем я вообще их использовал?
        // Double x = Double.valueOf(4); Выдаёт предупреждение unnecessary boxing
        // Это при том, что double x = 4 вполне себе работает, ✞Боже, спаси и сохрани✞
        // Вывод: Стоит писать либо Double x = 4.0, либо Double x = (double) 4
    }
}
