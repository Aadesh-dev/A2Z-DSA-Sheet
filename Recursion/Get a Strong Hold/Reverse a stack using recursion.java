class Solution
{ 
    static void reverse(Stack<Integer> s)
    {
        if(s.empty()) return;
        int num = s.pop();
        reverse(s);
        insertAtBottom(s, num);
    }
    
    static void insertAtBottom(Stack<Integer> s, int num) {
        if(s.empty()) {
            s.push(num);
            return;
        }
        int num2 = s.pop();
        insertAtBottom(s, num);
        s.push(num2);
    }
}
//Time: O(n), Space: O(n)