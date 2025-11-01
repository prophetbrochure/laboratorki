package Laba1_Base.Laba1_1;

import java.util.*;

public class Main {
    static boolean isNorm(String str) {
        Deque<Character> stack = new ArrayDeque<>();

        List<Character> open = List.of('[', '{', '(');
        List<Character> close = List.of(']', '}', ')');

        Map<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');

        for (Character c : str.toCharArray()) {
            if (open.contains(c)) {
                stack.push(c);
            } else if (close.contains(c)) {
                if (map.get(c) == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String stroka = "([{}{}])";
        System.out.println(isNorm(stroka) ? "Norm" : "Ne norm");
    }
}