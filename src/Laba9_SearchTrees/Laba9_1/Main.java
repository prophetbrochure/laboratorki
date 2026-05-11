package Laba9_SearchTrees.Laba9_1;

public class Main {
    public static void main(String[] args){
        BstNode tree = new BstNode(10);

        tree.insert(15);
        tree.insert(5);
        tree.insert(2);
        tree.insert(1);

        System.out.println(tree.has(1));
        tree.delete(1);
        System.out.println(tree.has(1));




    }
}
