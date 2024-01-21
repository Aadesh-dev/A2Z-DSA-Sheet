class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
      Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                if(arr1[0] < arr2[0]) {
                    return -1;
                } else if(arr1[0] > arr2[0]) {
                    return 1;
                } else {
                    return arr1[1] - arr2[1];
                }
            }
        });
      int min = 0, prevEnd = intervals[0][1];
      for(int i = 1; i < intervals.length; i++) {
          if(intervals[i][0] < prevEnd) {
              prevEnd = Math.min(prevEnd, intervals[i][1]);
              min++;
          } else {
              prevEnd = intervals[i][1];
          }
      }
      return min;  
    }
}
//Time: O(N log N + N), Space: O(1)
//https://www.youtube.com/watch?v=nONCGxWoUfM&ab_channel=NeetCode