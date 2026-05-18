package Laba7_DynamicProgramming.Laba7_3;

public class Main {
    public static int lcsLength(char[] x, char[] y) {
        int[] a = new int[x.length + 1];
        int[] b = new int[y.length + 1];

        for (int i = 1; i <= x.length; i++) {
            a[i] = x[i - 1];
        }

        for (int i = 1; i <= y.length; i++) {
            b[i] = y[i - 1];
        }

        if (a.length - 1 < b.length - 1) {
            int[] temp = a;
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
