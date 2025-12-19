package Laba4_MinSearch.Laba4_2;

public interface PriorityQueue<T extends Comparable<T>> {
    void enqueue(T value);

    void dequeueMax();

    void increment(long operation, T addition);
}
