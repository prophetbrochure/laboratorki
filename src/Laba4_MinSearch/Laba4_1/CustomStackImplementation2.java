package Laba4_MinSearch.Laba4_1;

public class CustomStackRealisation2<T extends Comparable<T>> implements CustomStack<T> {
    private class Node {
        private final T data;
        private final Node prev;
        private final T min;

        Node(T data, Node prev) {
            this.data = data;
            this.prev = prev;
            if (this.prev == null || this.data.compareTo(prev.getMin()) < 0) {
                this.min = this.data;
            } else {
                this.min = prev.getMin();
            }
        }

        public T getData() {
            return data;
        }

        public Node getPrev() {
            return prev;
        }

        public T getMin() {
            return min;
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
        return head.getMin();
    }
}
