import java.util.Stack;

public class Solution {
    public static String prefixToInfixConversion(String exp) {
        Stack<String> s = new Stack<>();
        for(int i = exp.length() - 1; i >= 0 ; i--) {
            char c = exp.charAt(i);
            String str = String.valueOf(c); 
            if(Character.isLetterOrDigit(c)) {
                s.push(str);
            } else {
                s.push("(" + s.pop() + str + s.pop() + ")");
            }
        }
        return s.pop();
    }
}
//Time: O(n), Space: O(n)
//https://www.youtube.com/watch?v=b6m4f2xwRjM&ab_channel=Education4u