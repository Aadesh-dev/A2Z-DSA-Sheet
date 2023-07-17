class Solution {
    public boolean rotateString(String s, String goal) {
        StringBuilder sb = new StringBuilder(s);
        for(int i=0; i<s.length(); i++) {
            char c = sb.charAt(0);
            for(int j=0; j<s.length() - 1; j++) {
                sb.replace(j, j+1, String.valueOf(sb.charAt(j+1)));
            }
            sb.replace(s.length() - 1, s.length(), String.valueOf(c));
            if(sb.toString().equals(goal)) return true;
        }
        return false;
    }
}

//Time: O(s^2), Space: O(s)

class Solution {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s+s).contains(goal);
    }
}

//Time: O(s^2), Space: O(s)

class Solution {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length())
            return false;
        if (A.length() == 0)
            return true;

        search:
            for (int s = 0; s < A.length(); ++s) {
                for (int i = 0; i < A.length(); ++i) {
                    if (A.charAt((s+i) % A.length()) != B.charAt(i))
                        continue search;
                }
                return true;
            }
        return false;
    }
}

//Time: O(s^2), Space: O(1)

class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        String c = s+s;
        return customContains(c, goal);
    }

    public static boolean customContains(String source, String target) {
        int goalIndex = 0, i=0;
        while(i<source.length()) {
            if(source.charAt(i) == target.charAt(goalIndex)) {
                goalIndex++;
                if(goalIndex == target.length()) {
                    return true;
                } 
                i++;
            } else {
                if(goalIndex == 0) {
                    i++;
                } else {
                    goalIndex = 0;
                }
            }
        }
        return false;
    }
}

//Time: O(s), Space: O(s)

class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        return customContains(s, goal);
    }

    public static boolean customContains(String source, String target) {
        int targetIndex = 0, i=0;
        while(i < 2 * source.length()) {
            if(source.charAt(i >= source.length() ? i % source.length() : i) == target.charAt(targetIndex)) {
                targetIndex++;
                if(targetIndex == target.length()) {
                    return true;
                } 
                i++;
            } else {
                if(targetIndex == 0) {
                    i++;
                } else {
                    targetIndex = 0;
                }
            }
        }
        return false;
    }
}

//Time: O(s), Space: O(1)

// i is not incremented on line 96 because of below test case.
// s =
// "vcuszhlbtpmksjleuchmjffufrwpiddgyynfujnqblngzoogzg"
// goal =
// "fufrwpiddgyynfujnqblngzoogzgvcuszhlbtpmksjleuchmjf"
