package Laba4_MinSearch.Laba4_2;

public class Main {
    public static void main(String[] args) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueueImplementation2();



      for (int i = (int) Math.pow(2, 4) - 1 ; i > 0; i--) {
           priorityQueue.enqueue(i);
      }

       priorityQueue.increment(1, 10);

        for(int i = 0; i < Math.pow(2, 5)-1; i++){
            priorityQueue.dequeueMax();
        }



    }
}
