import java.util.Stack;
public class Solution {
    public static String postfixToPrefix(String exp) {
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            String str = String.valueOf(c); 
            if(Character.isLetterOrDigit(c)) {
                stack.push(str);
            } else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                stack.push(str + op2 + op1);
            }
        }
        return stack.pop();
    }
}
//Time: O(n), Space: O(n)