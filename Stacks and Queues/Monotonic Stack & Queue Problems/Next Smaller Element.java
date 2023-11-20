import java.util.*;
import java.io.*;

public class Solution{
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        for(int i = arr.size() - 1; i >= 0 ; i--) {
            while(!s.isEmpty() && s.peek() >= arr.get(i)) s.pop();
            if(s.isEmpty()) {
                list.add(-1);
            } else {
                list.add(s.peek());
            } 
            s.push(arr.get(i));
        }
        Collections.reverse(list);
        return list;
    }
}
//Time: O(n), Space: O(n)