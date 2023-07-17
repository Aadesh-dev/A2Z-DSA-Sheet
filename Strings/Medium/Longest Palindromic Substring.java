//TLE
class Solution {
    public String longestPalindrome(String s) {
        String longest = Character.toString(s.charAt(0));
        int longestLength = 1;
        for(int i = 0; i < s.length() - 1; i++) {
            boolean isPalindrome = true;
            for(int j = i + 1; j < s.length(); j++) {
                isPalindrome = checkPalidrome(s, i, j);
                if(isPalindrome && (j - i + 1) > longestLength) {
                    longestLength = j - i + 1;
                    longest = s.substring(i, j+1);
                }
            }
        }
        return longest;
    }

    static boolean checkPalidrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end))  {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
//Time: O(n^3), Space: O(1)

class Solution {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for(int i = 0; i < s.length() - 1; i++) {
            int len1 = expandFromMiddle(s, i, i);
            int len2 = expandFromMiddle(s, i, i + 1);
            int len = Math.max(len1, len2);
            if(len > end - start + 1) {
                start = i - ((len - 1) / 2);
                end = i + (len/2);
            }
        }
        return s.substring(start, end + 1);
    }

    static int expandFromMiddle(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
//Time: O(n^2), Space: O(1)
//https://www.youtube.com/watch?v=y2BD4MJqV20&ab_channel=NickWhite
//Intuition:
//Each character is considered the middle of a palindromic substring. We expand to the left and right of that character to determine whether this is true.
//Then we store the length of the palindrome and keep a track of the max palindromic substring length.
//This works because the largest palindromic substring will have a character as its midpoint and that character will be somewhere in the array.
//
//Code explanation:
//1) start and end will track the index start and index end respectively of the longest palindrome substring
// 2) expandFromIndex method is called for each index using two pointers, left and right, and each time it's checking that the string is a palindrome and continues to expand. This method is called twice for every index for the two different cases of a palindrome, "aba" and "abba".
// 3) if (len > end - start) - start and end represents the index for the longest palindrome substring, so if the len (which is Math.max(len1, len2) is greater than the current largest palindrome substring then we want to update start and end. 
// 4) start = i - ((len-1)/2) and end = i + (len/2) --> this is really easy understand if you understand that "i" in this case is the centre of the longest palindrome. so let's say the longest palindrome of "aba" is "aba", and i would be index 1 which is the centre of the palindrome, then follow the formula to find the index of the beginning of "aba" 
