class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int content = 0;
        for(int i = 0; i < g.length; i++) {
            int cookie = -1;
            boolean hasFound = false;
            for(int j = 0; j < s.length; j++) {
                if(s[j] >= g[i] && (cookie == -1 || s[j] <= s[cookie])) {
                    hasFound = true;
                    cookie = j;
                }
            }
            if(hasFound) {
                content++;
                s[cookie] = 0;
            }
        }
        return content;
    }
}
//Time: O(g * s), Space: O(1)

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int contentChildren = 0;
        int cookieIndex = 0;
        while (cookieIndex < s.length && contentChildren < g.length) {
            if (s[cookieIndex] >= g[contentChildren]) {
                contentChildren++;
            }
            cookieIndex++;
        }
        return contentChildren;
    }

}
//Time: O(g log(g) + s log(s))
//Space: O(log(g) + log(s)) - In Java, Arrays.sort() is implemented using a variant of the Quick Sort algorithm which has a space complexity of O(log⁡n+log⁡m)O(\log n + \log m)O(logn+logm) for sorting two arrays.