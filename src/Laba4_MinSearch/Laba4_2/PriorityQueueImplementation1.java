package Laba4_MinSearch.Laba4_2;

public class PriorityQueueImplementation1 implements PriorityQueue<Integer> {
    private class Node {
        long i;
        Integer data;
        final Node parent;
        Node left = null;
        Node right = null;

        Node(long i, Integer data, Node parent) {
            this.i = i;
            this.parent = parent;
            this.data = data;
        }
    }

    void swapValues(Node a, Node b) {
        Integer tempData = a.data;
        a.data = b.data;
        b.data = tempData;
        long tempI = a.i;
        a.i = b.i;
        b.i = tempI;
    }

    Node maxOf(Node a, Node b) {
        return (a.data.compareTo(b.data) > 0) ? a : b;
    }

    private Node recursiveSearch(Node node, long i) {
        if (node == null) return null;
        if (node.i == i) return node;

        Node left = recursiveSearch(node.left, i);
        if (left != null) return left;

        return recursiveSearch(node.right, i);
    }


    Node head;
    long additionId;
    long pointer = 1;
    boolean isEmpty = true;


    @Override
    public void enqueue(Integer newData) {
        if (isEmpty) {
            System.out.println("Добавляем корневой узел " + pointer + "\n");
            head = new Node(additionId, newData, null);
            isEmpty = false;
        } else {
            System.out.println("Добавляем узел " + pointer);
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
                System.out.println("Записали узел " + pointer + " в левую ветвь\n");
                currentNode.left = new Node(additionId, newData, currentNode);
                currentNode = currentNode.left;

            } else {
                System.out.println("Записали узел " + pointer + " в правую ветвь\n");
                currentNode.right = new Node(additionId, newData, currentNode);
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
        additionId++;
    }

    @Override
    public void dequeueMax() {
        if (isEmpty) {
            System.out.println("Попытка удалить из пустой очереди\n");
            return;
        } else {
            System.out.println("Удаляем узел " + (pointer - 1) + "\n");
            int height = (int) (Math.log(pointer - 1) / Math.log(2));   // Math.log(x) = ln(x)
            long newPointer = pointer - 1 - (long) Math.pow(2, height);
            Node currentNode = head;

            for (int i = height - 1; i > 0; i--) {
                if (newPointer >= (long) Math.pow(2, i)) {
                    currentNode = currentNode.right;
                    newPointer -= (long) Math.pow(2, i);
                } else {
                    currentNode = currentNode.left;
                }
            }
            if (currentNode.right != null) {
                swapValues(head, currentNode.right);
                currentNode.right = null;
            } else if (currentNode.left != null){
                swapValues(head, currentNode.left);
                currentNode.left = null;
            }
            currentNode = head; // просеивание сверху вниз
            while (!(currentNode.left == null && currentNode.right == null)) {
                if (currentNode.right == null) {
                    if (currentNode.data.compareTo(currentNode.left.data) < 0) {
                        currentNode = currentNode.left;
                        swapValues(currentNode, currentNode.parent);
                    } else {
                        break;
                    }
                }
                if (currentNode.data.compareTo(currentNode.left.data) < 0 || currentNode.data.compareTo(currentNode.right.data) < 0) {
                    currentNode = currentNode.left.data.compareTo(currentNode.right.data) > 0 ? currentNode.left : currentNode.right;
                    swapValues(currentNode, currentNode.parent);
                } else {
                    break;
                }
            }
        }
        pointer--;
        if(pointer == 1){
            isEmpty = true;
        }
    }

    @Override
    public void increment(long id, java.lang.Integer addition) {   // Зачем вообще было использовать дженерики, если в этой сигнатуре дан Integer???
        if (isEmpty) {
            System.out.println("Попытка увеличить элеммент в пустой очереди!\n");
        }

        Node result = recursiveSearch(head, id);

        if(result == null){
            System.out.println("Попытка увеличить несуществующий узел");
            return;
        }

        System.out.println("Увеличиваем элемент с id " + result.i + " на" + addition);

        result.data += addition;

        Node currentNode = result; // просеивание сверху вниз
        while (!(currentNode.left == null && currentNode.right == null)) {
            if (currentNode.right == null) {
                if (currentNode.data.compareTo(currentNode.left.data) < 0) {
                    currentNode = currentNode.left;
                    swapValues(currentNode, currentNode.parent);
                } else {
                    break;
                }
            }
            if (currentNode.data.compareTo(currentNode.left.data) < 0 || currentNode.data.compareTo(currentNode.right.data) < 0) {
                currentNode = currentNode.left.data.compareTo(currentNode.right.data) > 0 ? currentNode.left : currentNode.right;
                swapValues(currentNode, currentNode.parent);
            } else {
                break;
            }
        }


    }
}