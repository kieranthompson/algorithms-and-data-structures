package algorithms_and_data_structures;

import java.util.HashMap;
import java.util.Stack;

public class BalancedString {

    public static String isBalanced(String string) {

        //This is our user defined map that will be used to test each iteration of the string
        HashMap<Character, Character> bmap = new HashMap<Character, Character>();
        bmap.put('(', ')');
        bmap.put('{', '}');
        bmap.put('[', ']');

        //an empty stack, all keys will be added to it, if the value is found in sequential order the pair will be removed
        Stack<Character> bstack = new Stack<Character>();


        for(char bracket : string.toCharArray()) {
            //if the current iteration(bracket) of our string contains any keys from the map, it will add them to the stack
            if (bmap.containsKey(bracket)) {
                bstack.push(bracket);
            }
            //this will check for empty stacks after the first iteration, if it is, then we know that the string is unbalanced or empty
            if(bstack.isEmpty()) {
                return "NO";
            }
            //if the current iteration(bracket) is the value of the latest key added to the stack then we have a pair! no we can pop it!
            else if (bmap.get(bstack.peek()) == bracket) {
                bstack.pop();
            }
        }
        //if we have successfully popped each existing pair from the stack then the string was balanced
        if(bstack.isEmpty()) {
            return string + ": YES";
        } else
            return string + ": NO";


    }

    public static void main(String [] args) {

        String test1 = "{}[]()";
        String test2 = "({[]})";
        String test3 = "(({{}})";
        String test4 = "(({{)";
        String test5 = "{[[}){}{}{}}{{}{))))";
        String test6 = "][(]}})(";

        System.out.println(isBalanced(test1));
        System.out.println(isBalanced(test2));
        System.out.println(isBalanced(test3));
        System.out.println(isBalanced(test4));
        System.out.println(isBalanced(test5));
        System.out.println(isBalanced(test6));
    }
}
