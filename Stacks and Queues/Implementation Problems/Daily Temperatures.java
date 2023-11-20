class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> temps = new Stack<>();
        int days[] = new int[n];
        for(int i = n - 1; i >= 0; i--) {
            while(!temps.isEmpty() && temperatures[temps.peek()] <= temperatures[i]) temps.pop();
            if(temps.isEmpty()) {
                days[i] = 0;
            } else {
                days[i] = temps.peek() - i;
            }
            temps.push(i);
        }
        return days;
    }
}
//Time: O(n), Space: O(n)