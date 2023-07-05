class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                if(map.get(s.charAt(i)) != t.charAt(i)) return false;
            } else {
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        map = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            if(map.containsKey(t.charAt(i))) {
                if(map.get(t.charAt(i)) != s.charAt(i)) return false;
            } else {
                map.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }
}

//Time: O(s + t), Space: O(1)
//Space is O(1) because the strings only contain ASCII chars and ASCII can only range from 1 to 256.
//So hash maps will never exceed 256 length no matter the input strings' length.

//Leetcode's editorial solution:

class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        int[] mappingDictStoT = new int[256];
        Arrays.fill(mappingDictStoT, -1);
        
        int[] mappingDictTtoS = new int[256];
        Arrays.fill(mappingDictTtoS, -1);
        
        for (int i = 0; i < s.length(); ++i) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            
            // Case 1: No mapping exists in either of the dictionaries
            if (mappingDictStoT[c1] == -1 && mappingDictTtoS[c2] == -1) {
                mappingDictStoT[c1] = c2;
                mappingDictTtoS[c2] = c1;
            }
            
            // Case 2: Ether mapping doesn't exist in one of the dictionaries or Mapping exists and
            // it doesn't match in either of the dictionaries or both 
            else if (!(mappingDictStoT[c1] == c2 && mappingDictTtoS[c2] == c1)) {
                return false;
            }
        }
        
        return true;
    }
}

//Time: O(s), Space: O(1)

//My approach improved:

class Solution
{
    //Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String str1,String str2)
    {
        if(str1.length() != str2.length()) return false;
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        
        for(int i = 0; i < str1.length(); i++) {
            Character c1 = str1.charAt(i);
            Character c2 = str2.charAt(i);
            if(!map1.containsKey(c1) && !map2.containsKey(c2)) {
                map1.put(c1, c2);
                map2.put(c2, c1);
            } else if(map1.get(c1) != c2 || map2.get(c2) != c1) {
                return false;
            }
        }
        return true;
        
    }
}

//Time: O(s), Space: O(1)

//Smarter
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int m1[] = new int[256], m2[] = new int[256], n = s.length();
        for (int i = 0; i < n; ++i) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        return true;
    }
}

//Time: O(s), Space: O(1)