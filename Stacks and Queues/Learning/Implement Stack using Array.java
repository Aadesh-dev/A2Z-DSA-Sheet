public class Solution{
    static class Stack {
        int arr[], index = -1;
        Stack(int capacity) {
            arr = new int[capacity];
        }
        public void push(int num) {
            if(isFull() == 0) {
                arr[++index] = num;
            }
        }
        public int pop() {
            return isEmpty() != 1 ? arr[index--] : -1;
        }
        public int top() {
            return isEmpty() != 1 ? arr[index] : -1;
        }
        public int isEmpty() {
            return index == -1 ? 1 : 0;
        }
        public int isFull() {
            return index == arr.length - 1 ? 1 : 0;
        }
    }
}
//Time :O(1), Space: O(n)