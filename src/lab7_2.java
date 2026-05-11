import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lab7_2{
    public static void main(String[] args){
        int[] a = {1,2, 1,3, 1,4,1 ,5 ,1 ,6,1 };


        int[] prev = new int[a.length];
        int[] d = new int[a.length];

        for(int i = 0; i < a.length; i++){
            d[i] = 1;
            prev[i] = -1;

            for(int j = 0; j < a.length; j++){
                if(a[j] < a[i] && d[j] + 1 > d[i]){
                    d[i] = d[j] + 1;
                    prev[i] = j;
                }
            }
        }

        int pos = 0;                            // индекс последнего элемента НВП
        int length = d[0];                      // длина НВП
        for (int i = 0; i < a.length; i++) {
            if (d[i] > length) {
                pos = i;
                length = d[i];
            }
        }

        List<Integer> answer = new ArrayList<>(length);
        while(pos != -1) {
            answer.add(a[pos]);
            pos = prev[pos];
        }

        System.out.println("Исходная последовательность :" + Arrays.toString(a));
        System.out.println("Длина наибольшей возрастающей подпоследовательности: " + length);
        System.out.println(answer.reversed());
    }
}
