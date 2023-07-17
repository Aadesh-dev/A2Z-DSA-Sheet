public class Solution {
    public static int countSubStrings(String str, int k) {
        int res = 0;
        for(int i=0; i<str.length(); i++) {
            Set<Character> set = new HashSet<>();
            int distinct = 0;
            for(int j=i; j<str.length(); j++) {
                if(!set.contains(str.charAt(j))) {
                    distinct++;
                }
                if(distinct == k) {
                    res++;
                } else if(distinct > k) break;
                set.add(str.charAt(j));
            }
        }
        return res;
    }
}
//Time: O(n^2), Space:O(1)
//Space is O(1) because at any time set will store a max of 26 characters as HashSet doesn't store duplicates.

public class Solution {
	public static int countSubStrings(String str, int k) {
		int result = 0;

		// Array to store count of characters.
		int[] count = new int[26];

		// All substrings.
		for (int i = 0; i < str.length(); i++) {
			int distinctChars = 0;

			// Initializing count array with zero for every iteration.
			Arrays.fill(count, 0);

			for (int j = i; j < str.length(); j++) {

				if (count[str.charAt(j) - 'a'] == 0) {
					distinctChars++;
				}

				// Increment count of current character.
				count[str.charAt(j) - 'a']++;

				if (distinctChars == k) {
					result++;
				}
			}
		}

		return result;
	}
}
//Time: O(n^2), Space:O(1)

//Optimal:
public class Solution {
    public static int helper(String str, int k) {

		int i = 0, j = 0, distinct = 0;
		int result = 0;

		// Array to store count of characters.
		int[] count = new int[26];

		while (j < str.length()) {
			// Index for current character.
			int index = str.charAt(j) - 'a';

			// Increment count for the current character.
			count[index]++;

			if (count[index] == 1) {
				distinct++;
			}

			// Decrement count and increase ith pointer.
			while (distinct > k) {
				count[str.charAt(i) - 'a']--;
				if (count[str.charAt(i) - 'a'] == 0) {
					distinct--;
				}

				i++;
			}

			// Total substrings.
			result += (j - i + 1);
			j++;
		}
		return result;
	}

	public static int countSubStrings(String str, int k) {

		// Calculating for at most k and at most k-1 distinct chars.
		int ans = helper(str, k) - helper(str, k - 1);
		return ans;
	}

}
//Time Complexity: O(N), Space complexity: O(1)

//The idea is to use a sliding window to count the number of substrings with at most K different characters because finding substrings with exactly K characters will again cost us N ^ 2 times. Therefore the number of substrings with exactly K different characters will be the number of substrings with at most K different characters - number of substrings with at most (K-1) different characters.
//There should be at most k chars in the sliding window at any point.

