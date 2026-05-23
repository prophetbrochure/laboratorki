package Laba9_SearchTrees.Laba9_1;

public class Main {
    public static void main(String[] args){
        BstNode tree = new BstNode(10);

        int[] array = {15, 5, 2, 1};
        for(int i : array){
            tree.insert(i);
        }

        System.out.println(tree.has(1));
        tree = tree.nerdEmojiDelete(1);
        System.out.println(tree.has(1));






    }
}
