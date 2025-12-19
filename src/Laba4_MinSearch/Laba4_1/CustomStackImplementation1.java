package Laba4_MinSearch.Laba4_1;

public class CustomStackImplementation1<T extends Comparable<T>> implements CustomStack<T> {
    private class Node {
        private final T data;
        private final Node prev;

        Node(T data, Node prev) {
            this.data = data;
            this.prev = prev;
        }

        public T getData() {
            return data;
        }

        public Node getPrev() {
            return prev;
        }
    }

    private Node head = null;

    @Override
    public T top() {
        return head != null ? head.getData() : null;
    }

    @Override
    public T pop() {
        if (head != null) {
            Node popped = head;
            head = head.getPrev();
            return popped.data;
        } else {
            return null;
        }
    }

    @Override
    public void push(T newData) {
        head = new Node(newData, head);
    }

    @Override
    public T min() {
        if (head == null) {
            return null;
        }
        T minValue = head.getData();
        Node current = head;
        while (current != null) {
            if (current.getData().compareTo(minValue) < 0) {
                minValue = current.getData();
            }
            current = current.prev;
        }
        return minValue;
    }
}
