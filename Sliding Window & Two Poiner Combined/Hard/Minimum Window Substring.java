//TLE
class Solution {
    public String minWindow(String s, String t) {
       int minLen = Integer.MAX_VALUE;
       String minString = "";
       for(int i = 0; i < s.length(); i++) {
           int char_occurrences[] = new int[t.length()];
           for(int j = i; j < s.length(); j++) {
               boolean subStringFound = true;
               if(t.contains(s.substring(j, j + 1))) {
                   int index = t.indexOf(s.charAt(j));
                   while(index != -1 && char_occurrences[index] != 0) {
                       index = t.indexOf(s.charAt(j), index + 1);
                   }
                   if(index != -1) char_occurrences[index]++;
                   for(int k = 0; k < char_occurrences.length; k++) {
                       if(char_occurrences[k] == 0) {
                           subStringFound = false;
                           break;
                       }
                   }
                   if(subStringFound == true) {
                       if(minLen > j - i + 1) {
                           minLen = j - i + 1;
                           minString = s.substring(i, j + 1);
                       }
                       break;
                   }
               }
           }
       }
       return minString; 
    }
}
//Time: O(s^2 * t^2), Space: O(t) => O(26) => O(1)

class Solution {
    public String minWindow(String s, String t) {
       int minLen = Integer.MAX_VALUE, i = 0, j = 0, have = 0, need = t.length();
       String minString = "";
       Map<Character, Integer> window_char_count = new HashMap<>(), t_char_count = new HashMap<>();
       for(int k = 0; k < t.length(); k++) {
           t_char_count.put(t.charAt(k), t_char_count.getOrDefault(t.charAt(k), 0) + 1);
       }
       while(j < s.length()) {
           if(t_char_count.containsKey(s.charAt(j))) {
               window_char_count.put(s.charAt(j), window_char_count.getOrDefault(s.charAt(j), 0) + 1);
               
               if(window_char_count.get(s.charAt(j)) <= t_char_count.get(s.charAt(j))) {
                   have++;
               }
               while(have == need) {
                   if(minLen > j - i + 1) {
                        minLen = j - i + 1;
                        minString = s.substring(i, j + 1);
                    }
                   if(t_char_count.containsKey(s.charAt(i))) {
                       window_char_count.put(s.charAt(i), window_char_count.getOrDefault(s.charAt(i), 0) - 1);
                       if(window_char_count.get(s.charAt(i)) < t_char_count.get(s.charAt(i))) {
                   have--;
               }
                   }
                   i++;
               }
           }
           j++;
       }
       return minString; 
    }
}
//Time: O(s), Space: O(t) => O(26) => O(1)