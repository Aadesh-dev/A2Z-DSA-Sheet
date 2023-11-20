//CodingNinjas and GFG:
import java.util.Stack;

public class Solution {
    public static int[] nextGreaterElement(int[] arr, int n) {
        int res[] = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i = arr.length - 1; i >= 0; i--) {
            while(!s.isEmpty() && s.peek() <= arr[i]) s.pop();
            if(s.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = s.peek();
            } 
            s.push(arr[i]);
        }
        return res;
    }
}
//Time: O(n), Space: O(n)

//Leetcode:
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int res[] = new int[nums1.length];
        Stack<Integer> s = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        for(int i = nums2.length - 1; i >= 0; i--) {
            if(map.containsKey(nums2[i])) {
                while(!s.isEmpty() && s.peek() <= nums2[i]) s.pop();
                if(s.isEmpty()) {
                    res[map.get(nums2[i])] = -1;
                } else {
                    res[map.get(nums2[i])] = s.peek();
                }
            }
            s.push(nums2[i]);
        }
        return res;
    }
}
//Time: O(n), Space: O(n)