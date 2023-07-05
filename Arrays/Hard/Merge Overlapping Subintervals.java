public int[][] merge(int[][] intervals) {
        int start, end;
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                if(arr1[0] < arr2[0]) {
                    return -1;
                } else if(arr1[0] > arr2[0]) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        List<List<Integer>> list = new ArrayList<>();
        //Set<Integer> set = new HashSet<>();
        for(int i=0; i<intervals.length; i++) {
            start = intervals[i][0];
            end = intervals[i][1];


            if(!list.isEmpty()) {
                if(start <= list.get(list.size() - 1).get(1)) continue;
            }


            for(int j = i + 1; j<intervals.length; j++) {
                if(intervals[j][0] <= end) {
                    end = Math.max(end, intervals[j][1]);
                }
            }


            list.add(new ArrayList<Integer>(Arrays.asList(start, end)));            
        }
        int[][] res = new int[list.size()][2];
        for(int i=0; i<list.size(); i++) {
            res[i] = list.get(i).stream().mapToInt(x -> x).toArray();
        }
        return res;
    }

//Time: O(N log N + N^2), Space: O(N)

public int[][] merge(int[][] intervals) {
        int start, end;
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        List<List<Integer>> list = new ArrayList<>();
        Integer[] temp = new Integer[2];
        temp[0] = intervals[0][0];
        temp[1] = intervals[0][1];
        for(int i=1; i<intervals.length; i++) {
            start = intervals[i][0];
            end = intervals[i][1];


            if(start <= temp[1]) {
                temp[1] = Math.max(temp[1], end);
            } else {
                list.add(new ArrayList<Integer>(Arrays.asList(temp[0], temp[1])));
                temp[0] = start;
                temp[1] = end;
            }          
        }
        list.add(new ArrayList<Integer>(Arrays.asList(temp[0], temp[1])));
        int[][] res = new int[list.size()][2];
        for(int i=0; i<list.size(); i++) {
            res[i] = list.get(i).stream().mapToInt(x -> x).toArray();
        }
        return res;
    }

//Time: O(N log N + N), Space: O(N)

//Smarter

class Solution {
    public int[][] merge(int[][] intervals) {
        int start, end;
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<intervals.length; i++) {
            if(list.isEmpty() || list.get(list.size() - 1).get(1) < intervals[i][0]) {
                list.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            } else {
                list.get(list.size() - 1).set(1, Math.max(list.get(list.size() - 1).get(1), intervals[i][1]));
            }        
        }
        int[][] res = new int[list.size()][2];
        for(int i=0; i<list.size(); i++) {
            res[i] = list.get(i).stream().mapToInt(x -> x).toArray();
        }
        return res;
    }
}

//Time: O(N log N + N), Space: O(N)
//Facebook follow-up: https://leetcode.com/problems/merge-intervals/editorial/comments/321556
