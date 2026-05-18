package Laba7_DynamicProgramming.Laba7_3;

public class Main {
    public static int lcsLength(char[] x, char[] y) {
        char[] a = new char[x.length + 1];          // Индексы в псевдокоде начинаются с 1, а не с 0. Очень удобно)))
        char[] b = new char[y.length + 1];
        System.arraycopy(x, 0, a, 1, x.length);
        System.arraycopy(y, 0, b, 1, y.length);

        if (a.length < b.length) {
            char[] temp = a;
            a = b;
            b = temp;
        }

        int m = a.length - 1;
        int n = b.length - 1;

        int[] lcs = new int[n + 1];

        for (int j = 0; j <= n; j++) {
            lcs[j] = 0;
        }

        int d = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int tmp = lcs[j];

                if (a[i] == b[j]) {
                    lcs[j] = d + 1;
                } else {
                    if (lcs[j] < lcs[j - 1]) {
                        lcs[j] = lcs[j - 1];
                    }
                }

                d = tmp;
            }
        }
        return lcs[n];
    }

    static void solve(String string1, String string2){
        System.out.println("\n\nСтрока 1:");
        System.out.println(string1);
        System.out.println("Строка 2:");
        System.out.println(string2);

        System.out.println("Длина наибольшей общей подпоследовательности: " + lcsLength(string1.toCharArray(), string2.toCharArray()));
    }


    public static void main(String[] args) {
        solve("ABC", "ABC");
        solve("ABCDE", "DCDA");
        solve("ABCDE", "XXXX");


    }
}
