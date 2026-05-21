/*
Дана последовательность чисел A=[a_1,a_2,...,a_n]. Нужно найти минимум M(i,j)
чисел на отрезке от i до j: M(i,j)= min(a_k), где i <= k < j

Используйте структуру данных дерево отрезков. Поиск минимума должен быть O(log(n))
 */

package Laba8_RangeQueries.Laba8_2;

import java.util.Arrays;

public class Main {
    static class SegmentTree {
        int[] array;

        /**
         * Дерево. У элемента i левый ребенок по адресу: 2 * i, правый по адресу 2 * i + 1
         * Каждый элемент является минимумом на своём отрезке
         * tree[1] минимум на всём массиве.
         * Размер (4 * размер массива) хз почему, так сказали ¯\_(ツ)_/¯
         */
        int[] tree;


        public SegmentTree(int[] array) {
            this.array = array;
            this.tree = new int[2 * array.length];

            build(1, 0, array.length - 1);
        }


        private void build(int treeIndex, int arrayLeftLimit, int arrayRightLimit) {
            if (arrayLeftLimit == arrayRightLimit) {
                tree[treeIndex] = array[arrayLeftLimit];
            } else {
                int middle = (arrayLeftLimit + arrayRightLimit) / 2;
                build(treeIndex * 2, arrayLeftLimit, middle);
                build(treeIndex * 2 + 1, middle + 1, arrayRightLimit);

                tree[treeIndex] = Math.min(tree[treeIndex * 2], tree[treeIndex * 2 + 1]);
            }
        }

        /**
         * Запрос минимума на отрезке [queryLeftLimit, queryRightLimit]
         * @param treeIndex индекс узла дерева
         * @param treeLeftLimit левая граница текущего сегмента дерева
         * @param treeRightLimit правая граница текущего сегмента дерева
         * @param queryLeftLimit левая граница запроса
         * @param queryRightLimit правая граница запроса
         * @return минимум на отрезке
         */
        private int recursiveQuery(int treeIndex,
                                   int treeLeftLimit,
                                   int treeRightLimit,
                                   int queryLeftLimit,
                                   int queryRightLimit) {

            // запрос вне текущего сегмента
            if (queryRightLimit < treeLeftLimit || queryLeftLimit > treeRightLimit) {
                return Integer.MAX_VALUE;
            }

            // сегмент входит в запрос
            if (queryLeftLimit <= treeLeftLimit && treeRightLimit <= queryRightLimit) {
                return tree[treeIndex];
            }


            int middle = (treeLeftLimit + treeRightLimit) / 2;

            int leftMin = recursiveQuery(
                    treeIndex * 2,
                    treeLeftLimit,
                    middle,
                    queryLeftLimit,
                    queryRightLimit
            );

            int rightMin = recursiveQuery(
                    treeIndex * 2 + 1,
                    middle + 1,
                    treeRightLimit,
                    queryLeftLimit,
                    queryRightLimit
            );

            return Math.min(leftMin, rightMin);
        }

        public int query(int left, int right) {
            return recursiveQuery(1, 0, array.length - 1, left, right);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int i = 3, j = 3;


        SegmentTree segmentTree = new SegmentTree(array);
//        System.out.println(Arrays.toString(segmentTree.tree));


        System.out.println("Изначальный массив:" + Arrays.toString(array));
        System.out.println("Отрезок: от " + i + " до " + j);
        System.out.println("Минимум на отрезке: " + segmentTree.query(i, j));
    }
}
