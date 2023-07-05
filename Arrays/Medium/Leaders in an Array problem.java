static ArrayList<Integer> leaders(int arr[], int n){
        ArrayList<Integer> list = new ArrayList<>();
        int max=Integer.MIN_VALUE;
        for(int i=n-1; i>=0; i--) {
            if(arr[i] >= max) {
                list.add(arr[i]);
                max = arr[i];
            }
        }
        Collections.reverse(list);
        return list;
    }

// Time: O(2*n), Space: O(n)

// If the return value is not arraylist then it can be smartly implemented in O(n) time:

Stack<Integer> stack = new Stack<Integer>();
        stack.push(arr[size - 1]);
  
        for (int i = size - 2; i >= 0; i--) {
            if (arr[i] >= stack.peek()) {
                stack.push(arr[i]);
            }
        }

//https://www.geeksforgeeks.org/leaders-in-an-array/	


