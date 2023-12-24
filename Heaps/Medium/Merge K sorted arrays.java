class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        ArrayList<Integer> mergedKArrays = new ArrayList<>();
        PriorityQueue<ArrayList<Integer>> heap = new PriorityQueue<>((n1, n2) -> n1.get(0) - n2.get(0));
        for(int i = 0; i < arr.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(arr[i][0]);
            list.add(0);
            list.add(i);
            heap.add(list);
        }
        while(!heap.isEmpty()) {
            ArrayList<Integer> min = heap.poll();
            mergedKArrays.add(min.get(0));
            if(min.get(1) + 1 < arr[min.get(2)].length) {
                min.set(1, min.get(1) + 1);
                min.set(0, arr[min.get(2)][min.get(1)]);
                heap.add(min);
            }
        }
        return mergedKArrays;
    }
}
//Time: O(n * 2 * logk) => O(n logk), Space: O(k)
//where k = number of arrays, n = total number of elements in all arrays