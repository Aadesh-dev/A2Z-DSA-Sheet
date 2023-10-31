import java.util.Stack;
public class Solution {
    public static String infixToPostfix(String exp) {
        String res = "";
        Stack<Character> s = new Stack<>();
        for(int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if(c == '^') {
                if(!s.isEmpty() && s.peek() == '^') {
                    res += s.pop();
                }
                s.push(c);
            } else if(c == '/' || c == '*') {
                while(!s.isEmpty() && (s.peek() == '/' || s.peek() == '*' || s.peek() == '^')) {
                    res += s.pop();
                }
                s.push(c);
            } else if(c == '+' || c == '-') {
                while(!s.isEmpty() && (s.peek() == '+' || s.peek() == '-' || s.peek() == '/' || s.peek() == '*' || s.peek() == '^')) {
                    res += s.pop();
                }
                s.push(c);
            } else if(c == '(') s.push(c);
            else if(c == ')') {
                while(s.peek() != '(') res += s.pop();
                s.pop();
            }
            else res += c;
        }
        while(!s.isEmpty()) res += s.pop();
        return res;
    }
}
//Time: O(n), Space: O(n)
//https://www.youtube.com/watch?v=MxKBRgyO-94&pp=ygUQaW5maXggdG8gcG9zdGZpeA%3D%3D