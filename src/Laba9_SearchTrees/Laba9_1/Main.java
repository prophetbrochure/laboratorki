package Laba9_SearchTrees.Laba9_1;

public class Main {
    public static void main(String[] args){
        BstNode tree = new BstNode(5);

        int[] addedArray = {1,2,4,5};
        int[] notAddedArray = {-1, 0, -2,3,  6, 10};


        for(int i : addedArray){
            tree.insert(i);
        }


        tree.delete(1);

        System.out.println(tree.has(1));

        tree.insert(1);
        System.out.println(tree.has(1));

        tree.delete(5);








    }
}
