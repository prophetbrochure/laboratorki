package Laba4_MinSearch.Laba4_2;

import java.util.ArrayList;

public class PriorityQueueImplementation2 implements PriorityQueue<Integer> {
    private static class Node {
        long i;
        Integer data;

        Node(long i, Integer data) {
            this.i = i;
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

    ArrayList<Node> array = new ArrayList<>();
    Integer idCounter = 1;

    @Override
    public void enqueue(Integer value) {
        array.add(new Node(idCounter, value));

        int currentPointer = array.size() - 1;

        while (currentPointer > 0) {
            int parent = (currentPointer - 1) / 2;
            if (array.get(currentPointer).data.compareTo(array.get(parent).data) > 0) {
                swapValues(array.get(currentPointer), array.get(parent));
                currentPointer = parent;
            } else {
                break;
            }
        }
        idCounter++;
    }

    @Override
    public void dequeueMax() {
        if (array.isEmpty()) {
            System.out.println("*");
            return;
        }

        System.out.println(array.getFirst().i + " " + array.getFirst().data);
        swapValues(array.getFirst(), array.getLast());
        array.removeLast();

        int current = 0;
        while (true) {
            int left = 2 * current + 1;
            int right = 2 * current + 2;
            int largest = current;

            // Сравниваем с левым потомком
            if (left < array.size() && array.get(left).data.compareTo(array.get(largest).data) > 0) {
                largest = left;
            }

            // Сравниваем с правым потомком
            if (right < array.size() && array.get(right).data.compareTo(array.get(largest).data) > 0) {
                largest = right;
            }

            if (largest == current) {
                break;
            }

            swapValues(array.get(current), array.get(largest));
            current = largest;
        }
    }

    @Override
    public void increment(long operation, Integer addition) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).i == operation) {
                array.get(i).data += addition;

                int current = i;
                while (true) {
                    int left = 2 * current + 1;
                    int right = 2 * current + 2;
                    int largest = current;

                    if (left < array.size() && array.get(left).data.compareTo(array.get(largest).data) > 0) {
                        largest = left;
                    }

                    if (right < array.size() && array.get(right).data.compareTo(array.get(largest).data) > 0) {
                        largest = right;
                    }

                    if (largest == current) {
                        break;
                    }

                    swapValues(array.get(current), array.get(largest));
                    current = largest;
                }
            }
        }
    }
}
