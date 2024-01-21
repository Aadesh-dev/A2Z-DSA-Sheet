class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) {
            int res[][] = new int[1][2];
            res[0] = newInterval;
            return res;
        }
        List<List<Integer>> list = new ArrayList<>();
        List<List<Integer>> merged = new ArrayList<>();
        boolean added = false;
        int j = 0;
        while(j < intervals.length) {
            if(!added && newInterval[0] <= intervals[j][0]) {
                list.add(Arrays.asList(newInterval[0], newInterval[1]));
                added = true;
            } else {
                list.add(Arrays.asList(intervals[j][0], intervals[j][1]));
                j++;
            }
        }
        if(list.size() < intervals.length + 1) {
            list.add(Arrays.asList(newInterval[0], newInterval[1]));
        }
        merged.add(Arrays.asList(list.get(0).get(0), list.get(0).get(1)));
        for(int i = 1; i < list.size(); i++) {
            int last = merged.get(merged.size() - 1).get(1);
            int first = list.get(i).get(0);
            int second = list.get(i).get(1);
            if(last < first) {
                merged.add(Arrays.asList(first, second));
            } else {
                merged.set(merged.size() - 1, Arrays.asList(merged.get(merged.size() - 1).get(0), Math.max(last, second)));
            }
        }

        int res[][] = new int[merged.size()][2];
        for(int i = 0; i < merged.size(); i++) {
            res[i] = merged.get(i).stream().mapToInt(x -> x).toArray();
        }    
        return res;
    }
}
//[1,2],[3,5],[4,8],[6,7],[8,10],[12,16]]
//Time: O(n), Space: O(n)
//Step 1: Insert the new interval such that after insertion all intervals are still sorted by the ascending order of their start times.
//Step 2: Run the merge overlapping intervals algorithm.

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int localNewInterval[] = IntStream.of(newInterval).toArray();
        
        for(int i = 0; i < intervals.length; i++) {
           if(localNewInterval[1] < intervals[i][0]) {
               list.add(localNewInterval);
               for(int j = i; j < intervals.length; j++) list.add(intervals[j]);
               return list.toArray(new int[list.size()][]);
           } else if(intervals[i][1] < localNewInterval[0]) {
               list.add(intervals[i]);
           } else {
               localNewInterval = new int[]{Math.min(intervals[i][0], localNewInterval[0]), Math.max(intervals[i][1], localNewInterval[1])};
           }
        }

        list.add(localNewInterval);
        return list.toArray(new int[list.size()][]);
    }
}
//Time: O(n), Space: O(n)
//https://www.youtube.com/watch?v=A8NUOmlwOlM&ab_channel=NeetCode
//3 cases need to be handled:
//Case 1 - New interval lies before the current interval:
//1. Add the new interval.
//2. Add the remaining intervals directly as we know there won't be any overlap after this.
//
//Case 2 - New interval lies after the current interval:
//1. Add the current interval.
//2. Don't add the new interval yet as there may be overlaps with the subsequent intervals.
//
//Case 3 - There is an overlap:
//1. Update the new interval to be the merged version of the 2 overlapping intervals.
//2. Keep comparing this new merged interval with the subsequent intervals.