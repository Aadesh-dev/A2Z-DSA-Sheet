/*
	This is signature of helper function 'knows'.
	You should not implement it, or speculate about its implementation.

	boolean knows(int A, int B); 
	Function 'knows(A, B)' will returns "true" if the person having
	id 'A' know the person having id 'B' in the party, "false" otherwise.
	Use it as Runner.knows(A, B);
*/
	
public class Solution {
	public static int findCelebrity(int n) {
        for(int i = 0; i < n; i++) {
			boolean celeb = true;
			for(int j = 0; j < n; j++) {
				if(i != j) {
					if(Runner.knows(i, j) || !Runner.knows(j, i)) {
						celeb = false;
						break;
					}
				}
			}
			if(celeb) {
				return i;
			}
		}
		return -1;
    }
}
//Time: O(n^2), Space: O(1)

public class Solution {
	public static int findCelebrity(int n) {
		int candidate = 0;
        for(int i = 1; i < n; i++) {
			if(Runner.knows(candidate, i)) {
				candidate = i;
			}
		}
		for(int i = 0; i < n; i++) {
			if(i != candidate && (Runner.knows(candidate, i) || !Runner.knows(i, candidate))) {
				return -1;
			}
		}
		return candidate;
    }
}
//Time: O(n), Space: O(1)
//The first loop determines that any element before or after the final candidate is not a celebrity.
//This is because all elements before the final candidate know atleast 1 other person and all elements after are not known by atleast 1 other person.
//https://www.youtube.com/watch?v=LZJBZEnoYLQ&ab_channel=KevinNaughtonJr.