package Laba9_SearchTrees.Laba9_1;

public class Main2 {
    public static void main(String[] args) {
        BstWrapper<Integer> tree = new BstWrapper<>();

        tree.insert(null);
        tree.has(null);
        tree.delete(null);
        tree.next(null);
        tree.prev(null);


        tree.insert(5);
        tree.insert(7);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.has(3);
        tree.has(8);
        tree.insert(8);
        tree.has(8);
        tree.delete(3);
        tree.delete(3);

        tree.next(7);
        tree.prev(5);


    }
}
