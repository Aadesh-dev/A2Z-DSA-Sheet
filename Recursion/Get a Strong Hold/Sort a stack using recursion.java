class GfG{
	public Stack<Integer> sort(Stack<Integer> s)
	{
		if(s.empty()) return s;
		int num = s.pop();
		Stack<Integer> sorted = sort(s);
		Stack<Integer> temp = new Stack<>();
		while(!sorted.empty() && num < sorted.peek()) {
		    temp.push(sorted.pop());
		}
		sorted.push(num);
		while(!temp.empty()) {
		    sorted.push(temp.pop());
		}
		return sorted;
	}
}
//Time complexity: O(n^2), Auxiliary Space: O(n)
//https://www.geeksforgeeks.org/sort-a-stack-using-recursion/

//Without any loops
import java.util.* ;
import java.io.*; 
public class Solution {

	public static void sortStack(Stack<Integer> stack) {
		if(stack.empty()) return;
		int num = stack.pop();
		sortStack(stack);
		sortInserted(stack, num);
	}

	static void sortInserted(Stack<Integer> stack, int x) {
		if(stack.empty() || x >= stack.peek()) {
			stack.push(x);
			return;
		}

		int temp = stack.pop();
		sortInserted(stack, x);
		stack.push(temp);
	}
}
//Time complexity: O(n^2), Auxiliary Space: O(n)

