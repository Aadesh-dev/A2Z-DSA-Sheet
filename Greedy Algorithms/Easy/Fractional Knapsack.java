class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        Arrays.sort(arr, (item1, item2) -> {
            double val1 = item1.value / (double)item1.weight;
            double val2 = item2.value / (double)item2.weight;
            if(val1 < val2) return 1;
            else if(val1 > val2) return -1;
            else return 0;
        });
        int availableWeight = W;
        double maxVal = 0.0;
        for(Item item : arr) {
            if(item.weight <= availableWeight) {
                maxVal += item.value;
                availableWeight -= item.weight;
            } else {
                maxVal += (item.value / (double)item.weight) * availableWeight;
                break;
            }
        }
        return maxVal;
    }
}
//Time: O(n log(n)), Space: O(1)