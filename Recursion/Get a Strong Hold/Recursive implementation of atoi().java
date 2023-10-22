class Solution
{
    int atoi(String str) {
        if(!str.substring(1, str.length()).matches("^\\d*$") || (str.charAt(0) != '-' && (str.charAt(0) - '0' < 0 || str.charAt(0) - '0' > 9))) return -1;
        if(str.charAt(0) == '-') {
            return -1 * recAtoi(str.substring(1, str.length()), str.length() - 1);
        }
	    return recAtoi(str, str.length());
    }
    
    static int recAtoi(String str, int n) {
        
        if(n == 1) {
            return str.charAt(0) - '0';
        }
        
        return (recAtoi(str, n-1) * 10 + str.charAt(n-1) - '0');
    }
}
//Time: O(n), Space: O(n)
//Problem: https://practice.geeksforgeeks.org/problems/implement-atoi/1
//Solution: https://www.geeksforgeeks.org/recursive-implementation-of-atoi/