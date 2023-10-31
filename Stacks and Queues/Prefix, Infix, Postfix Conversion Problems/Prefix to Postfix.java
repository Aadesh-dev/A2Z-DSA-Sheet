import java.util.Stack;
public class Solution {
    public static String preToPost(String s) {
        Stack<String> stack = new Stack<>();
        for(int i = s.length() - 1; i >= 0 ; i--) {
            char c = s.charAt(i);
            String str = String.valueOf(c); 
            if(Character.isLetterOrDigit(c)) {
                stack.push(str);
            } else {
                stack.push(stack.pop() + stack.pop() + str);
            }
        }
        return stack.pop();
    }
}
//Time: O(n), Space: O(n)