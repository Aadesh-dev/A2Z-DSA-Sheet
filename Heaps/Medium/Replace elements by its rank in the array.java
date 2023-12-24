class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int res[] = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            int rank = 1;
            Set<Integer> set = new HashSet<>();
            for(int j = 0; j < arr.length; j++) {
                if(arr[j] < arr[i] && !set.contains(arr[j])) rank++;
                set.add(arr[j]);
            }
            res[i] = rank;
        }
        return res;
    }
}
//Time: O(n^2), Space: O(n)

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int dummy[] = new int[arr.length];
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for(int i = 0; i < arr.length; i++) {
            dummy[i] = arr[i];
        }
        Arrays.sort(dummy);
        for(int i = 0; i < dummy.length; i++) {
            if(!map.containsKey(dummy[i])) {
                map.put(dummy[i], rank);
                rank++;
            };
        }
        for(int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}
//Time: O(n + n logn + n) => O(n logn), Space: O(n)