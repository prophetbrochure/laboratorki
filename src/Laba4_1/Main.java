package Laba4_1;

public class Main {
    public static void main(String[] args){
        CustomStack<Integer> customStack1 = new CustomStackRealisation1<>();

        customStack1.push(1);
        customStack1.push(2);
        customStack1.push(3);
        System.out.println(customStack1.min());
        

    }
}
