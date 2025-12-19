package Laba5_HashMap.Laba5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> hashMap1 = new HashMapImplementation<>();

        String line;
        String[] tokens;

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            tokens = line.split(" ");

            switch (tokens[0]) {
                case "put":
                    hashMap1.put(tokens[1], tokens[2]);
                    System.out.println("put(" + tokens[1] + " : " + tokens[2] + ")");
                    break;
                case "get":
                    System.out.println("get(" + tokens[1] + "):\n\t" + hashMap1.getValue(tokens[1]));
                    break;
                case "delete":
                    System.out.println("delete(" + tokens[1] + "):\n\t" + hashMap1.delete(tokens[1]));
                    break;
                default:
                    System.out.println("Неизвестная команда");
                    return;
            }
        }
    }
}
