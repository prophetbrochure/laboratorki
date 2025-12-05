package Laba4_MinSearch.Laba4_2;

public class Main {
    public static void main(String[] args) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueueImplementation1();

        for (int i = 0; i < Math.pow(2, 4) - 1; i++) {
            priorityQueue.enqueue(2);
        }

        priorityQueue.increment(1, 10);

//        for(int i = 0; i < Math.pow(2, 4)-1; i++){
//            priorityQueue.dequeueMax();
//        }
        priorityQueue.dequeueMax();


    }
}
