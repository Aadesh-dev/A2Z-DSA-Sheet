class Solution{
    static List<Integer> minPartition(int N)
    {
        List<Integer> list = new ArrayList<>();
        int noOfCoins = 0, remAmount = N;
        int coins[] = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        for(int i = coins.length - 1; i >= 0; i--) {
            while(coins[i] <= remAmount) {
                list.add(coins[i]);
                remAmount -= coins[i];
            }
            if(remAmount == 0) break; 
        }
        return list;
    }
}
//Time: O(N), Space: O(1)