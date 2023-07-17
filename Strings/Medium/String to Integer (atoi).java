class Solution {
    public int myAtoi(String s) {
        if(s.length() == 0) return 0;
        int res = 0;
        boolean negative = false, numberOrSignEncountered = false;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == ' ') {
                if(numberOrSignEncountered) break;
                continue;
            }
            if(s.charAt(i) == '+') {
                if((i != s.length() - 1 && (s.charAt(i+1) == '+' || s.charAt(i+1) == '-')) || numberOrSignEncountered) {
                    break;
                }
                numberOrSignEncountered = true;
                continue;
            }
            if(s.charAt(i) == '-') {
                if((i != s.length() - 1 && (s.charAt(i+1) == '+' || s.charAt(i+1) == '-')) || numberOrSignEncountered) {
                    break;
                }
                numberOrSignEncountered = true;
                negative = true;
                continue;
            }
            if(((int) s.charAt(i) >= 65 && (int) s.charAt(i) <= 90) || ((int) s.charAt(i) >= 97 && (int) s.charAt(i) <= 122) || s.charAt(i) == '.') {
                break;
            }
            if((long) res * 10.0 + (long) Character.getNumericValue(s.charAt(i)) > Integer.MAX_VALUE) {
                if(negative) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
            numberOrSignEncountered = true;
            res = res * 10 + Character.getNumericValue(s.charAt(i));
        }
        if(negative) {
            return res * -1;
        }
        return res;
    }
}
//Time: O(n), Space: O(1)

// Smarter:
class Solution {
    public int myAtoi(String s) {
        int index = 0, sign = 1, total = 0;
    //1. Empty string
    if(s.length() == 0) return 0;

    //2. Remove Spaces
    while(index < s.length() && s.charAt(index) == ' ')
        index ++;

    //3. Handle signs
    if(index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')){
        sign = s.charAt(index) == '+' ? 1 : -1;
        index ++;
    }
    
    //4. Convert number and avoid overflow
    while(index < s.length()){
        int digit = s.charAt(index) - '0';
        if(digit < 0 || digit > 9) break; // handles alphabet, space, + or -

        //check if total will be overflow after 10 times and add digit
        if((Integer.MAX_VALUE-digit)/10<total)
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        total = 10 * total + digit;
        index ++;
    }
    return total * sign;
    }
}
//Time: O(n), Space: O(1)