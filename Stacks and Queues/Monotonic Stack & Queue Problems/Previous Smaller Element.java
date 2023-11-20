public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < A.size(); i++) {
            while(!s.isEmpty() && s.peek() >= A.get(i)) s.pop();
            if(s.isEmpty()) {
                list.add(-1);
            } else {
                list.add(s.peek());
            } 
            s.push(A.get(i));
        }
        return list;
    }
}
//Time: O(n), Space: O(n)