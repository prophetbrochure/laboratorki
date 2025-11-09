package Laba4_MinSearch.Laba4_2;

public class PriorityQueueImplementation1<T extends Comparable<T>> implements PriorityQueue<T> {
    private class Node {
        long i;
        T data;
        final Node parent;
        Node left = null;
        Node right = null;

        Node(long i, T data, Node parent) {
            this.i = i;
            this.parent = parent;
            this.data = data;
        }
    }

    void swapValues(Node a, Node b) {
        T tempData = a.data;
        a.data = b.data;
        b.data = tempData;
        long tempI = a.i;
        a.i = b.i;
        b.i = tempI;
    }

    Node maxOf(Node a, Node b) {
        return (a.data.compareTo(b.data) > 0) ? a : b;
    }

//    Node recursiveSearch(Node node, long searchedI){
//        if(node.i == searchedI){
//            return node;
//        }
//
//    }

    Node head;
    long i;
    long pointer = 1;
    boolean isEmpty = true;


    @Override
    public void enqueue(T newData) {
        if (isEmpty) {
            System.out.println("Добавляем корневой узел " + pointer);
            head = new Node(i, newData, null);
            isEmpty = false;
        } else {
            System.out.println("\nДобавляем узел " + pointer);
            int height = (int) (Math.log(pointer) / Math.log(2));   // Math.log(x) = ln(x)
            long newPointer = pointer - (long) Math.pow(2, height);
            Node currentNode = head;

            for (int i = height - 1; i > 0; i--) {
                if (newPointer >= (long) Math.pow(2, i)) {
                    currentNode = currentNode.right;
                    newPointer -= (long) Math.pow(2, i);
                    System.out.println("Идём вправо...");
                } else {
                    currentNode = currentNode.left;
                    System.out.println("Идём влево...");
                }
            }
            if (currentNode.left == null) {
                System.out.println("Записали узел " + pointer + " в левую ветвь");
                currentNode.left = new Node(i, newData, currentNode);
                currentNode = currentNode.left;

            } else {
                System.out.println("Записали узел " + pointer + " в правую ветвь");
                currentNode.right = new Node(i, newData, currentNode);
                currentNode = currentNode.right;
            }
            while (currentNode.parent != null) {  // просеивание снизу вверх
                if (currentNode.data.compareTo(currentNode.parent.data) > 0) {
                    swapValues(currentNode, currentNode.parent);
                    currentNode = currentNode.parent;
                } else {
                    break;
                }
            }
        }
        pointer++;
        i++;
    }

    @Override
    public void dequeueMax() {
        if (isEmpty) {
            System.out.println("*");
            return;
        } else {
            // TODO
        }
        pointer--;
    }

    @Override
    public void increment(long operation, T addition) {
        if (isEmpty) {
            System.out.println("Queue is empty!");
        }
//        else{
//              // найти элемент, увеличить data на 5 и просеять снизу вверх
//
//        }
    }
}