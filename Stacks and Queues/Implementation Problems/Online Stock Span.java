class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        Stack<Integer> stack = new Stack<>();
        int spans[] = new int[n];
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && price[stack.peek()] <= price[i]) stack.pop();
            if(stack.isEmpty()) {
                spans[i] = i + 1;
            } else {
                spans[i] = i - stack.peek();
            }
            stack.push(i);
        }
        return spans;
    }
    
}
//Time: O(n), Space: O(n)

//LeetCode brute:
class StockSpanner {
    List<Integer> prices;

    public StockSpanner() {
        prices = new ArrayList<>();
    }
    
    public int next(int price) {
        prices.add(price);
        for(int i = prices.size() - 1; i >= 0; i--) {
            if(prices.get(i) > price) return prices.size() - i - 1;
        }
        return prices.size();
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
//Time: O(n) for every operation, Space: O(n)

class StockSpanner {
    Stack<Pair<Integer, Integer>> prices;

    public StockSpanner() {
        prices = new Stack<>();
    }
    
    public int next(int price) {
        int count = 1;
        while(!prices.isEmpty() && prices.peek().getKey() <= price) {
            count += prices.peek().getValue();
            prices.pop();
        }
        prices.push(new Pair(price, count));
        return count;
    }
}
//Time: Θ(1) amorized, O(n) worst, Space: O(n)

//More intuitive. A direct adaptation of the array based question.
class StockSpanner {
    Stack<Pair<Integer, Integer>> prices;
    int count = 1;

    public StockSpanner() {
        prices = new Stack<>();
    }
    
    public int next(int price) {
        while(!prices.isEmpty() && prices.peek().getKey() <= price) {
            prices.pop();
        }
        int span = prices.isEmpty() ? count : count - prices.peek().getValue();
        prices.push(new Pair(price, count));
        count++;
        return span;
    }
}
//Time: Θ(1) amorized, O(n) worst, Space: O(n)