
import java.util.*;


// Check that String contain equal no of brackets or not?

//Time - O(s.length)
//Space - O(s.length)

public class Parenthesis_Checker_or_balance_brackets {

    static boolean check(String s) {

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(s.charAt(i));

            else if (s.charAt(i) == ')' && !stack.empty() && stack.peek() == '(')
                stack.pop();

            else if (s.charAt(i) == ']' && !stack.empty() && stack.peek() == '[')
                stack.pop();

            else if (s.charAt(i) == '}' && !stack.empty() && stack.peek() == '{')
                stack.pop();

            else
                return false;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String s = "[()]{}{[()()]()}";
//        String s = "[()]{}{[()()(){]()}";

        System.out.println(check(s));

    }
}