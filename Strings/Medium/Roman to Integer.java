class Solution {
    public int romanToInt(String s) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int i = 0;
        while(i<s.length()) {
            if(s.charAt(i) == 'I' && i!=s.length() - 1) {
                if(s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X') {
                    result += map.get(s.charAt(i+1)) - map.get(s.charAt(i));
                    i+=2;
                } else {
                    result += map.get(s.charAt(i));
                    i++;
                }
            } else if(s.charAt(i) == 'X' && i!=s.length() - 1) {
                if(s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C') {
                    result += map.get(s.charAt(i+1)) - map.get(s.charAt(i));
                    i+=2;
                } else {
                    result += map.get(s.charAt(i));
                    i++;
                }
            } else if(s.charAt(i) == 'C' && i!=s.length() - 1) {
                if(s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M') {
                    result += map.get(s.charAt(i+1)) - map.get(s.charAt(i));
                    i+=2;
                } else {
                    result += map.get(s.charAt(i));
                    i++;
                }
            } else {
                result += map.get(s.charAt(i));
                i++;
            }
        }
        return result;
    }
}
//Time: O(n), Space: O(7) => O(1)

class Solution {
    public int romanToInt(String s) {
    
        int answer = 0, number = 0, prev = 0;

        for (int j = s.length() - 1; j >= 0; j--) {
            switch (s.charAt(j)) {
                case 'M' -> number = 1000;
                case 'D' -> number = 500;
                case 'C' -> number = 100;
                case 'L' -> number = 50;
                case 'X' -> number = 10;
                case 'V' -> number = 5;
                case 'I' -> number = 1;
            }
            if (number < prev) {
                answer -= number;
            }
            else {
                answer += number;
            }
            prev = number;
        }
        return answer;
    }
}
//Time: O(n), Space: O(1)
//The special scenario only happens when the current number is less than previous number.
//In this case there will be a subraction and in all other cases there will be an addition.