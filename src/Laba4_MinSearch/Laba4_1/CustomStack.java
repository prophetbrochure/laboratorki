package Laba4_MinSearch.Laba4_1;

public interface CustomStack<T extends Comparable<T>> {
    void push(T newData);

    T pop();

    T top();

    T min();
}
