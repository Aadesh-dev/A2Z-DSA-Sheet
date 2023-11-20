class Solution {
    public String removeKdigits(String num, int k) {
        int x = k;
        String res = "";
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < num.length(); i++) {
            int n = Character.getNumericValue(num.charAt(i));
            while(!s.isEmpty() && s.peek() > n && x > 0) {
                s.pop();
                x--;
            }
            if(!(s.isEmpty() && n == 0)) s.push(n);
        }
        while(!s.isEmpty() && x > 0) {
            s.pop();
            x--;
        }
        while(!s.isEmpty()) {
            res = Integer.toString(s.pop()) + res;
        }
        return res.length() == 0 ? "0" : res;
    }
}
//Time: O(n), Space: O(n)