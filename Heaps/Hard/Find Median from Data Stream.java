//TLE
class MedianFinder {

    List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        list.add(num);
    }
    
    public double findMedian() {
        Collections.sort(list);
        int size = list.size();
        if(size % 2 == 0) {
            return (list.get((size / 2) - 1) + list.get(size / 2)) / 2.00000;
        }
        return list.get(size / 2);
    }
}
//Time:
//addNum: O(1) 
//findMedian: O(n log(n))

//Space: O(n)

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

class MedianFinder {

    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxHeap.add(num);

        if(maxHeap.size() > 0 && minHeap.size() > 0 && maxHeap.peek() > minHeap.peek()) {
            minHeap.add(maxHeap.poll());
        }
        if(maxHeap.size() > 0 && minHeap.size() > 0 && minHeap.peek() < maxHeap.peek()) {
            maxHeap.add(minHeap.poll());
        }
        
        if(maxHeap.size() - minHeap.size() >= 2) {
            minHeap.add(maxHeap.poll());
        }
        if(minHeap.size() - maxHeap.size() >= 2) {
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else if(maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return minHeap.peek();
        }
    }
}
//Time:
//addNum: O(log (n)) 
//findMedian: O(1)

//Space: O(n)
//https://www.youtube.com/watch?v=itmhHWaHupI&ab_channel=NeetCode

//CodeStudio
import java.util.*;
public class Solution {
    public static int[] findMedian(int[] arr, int n) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int res[] = new int[n];

        for(int i = 0; i < n; i++) {
            maxHeap.add(arr[i]);

            if(maxHeap.size() > 0 && minHeap.size() > 0 && maxHeap.peek() > minHeap.peek()) {
                minHeap.add(maxHeap.poll());
            }
            if(maxHeap.size() > 0 && minHeap.size() > 0 && minHeap.peek() < maxHeap.peek()) {
                maxHeap.add(minHeap.poll());
            }
            
            if(maxHeap.size() - minHeap.size() >= 2) {
                minHeap.add(maxHeap.poll());
            }
            if(minHeap.size() - maxHeap.size() >= 2) {
                maxHeap.add(minHeap.poll());
            }

            if(maxHeap.size() == minHeap.size()) {
                res[i] = (maxHeap.peek() + minHeap.peek()) / 2;
            } else if(maxHeap.size() > minHeap.size()) {
                res[i] = maxHeap.peek();
            } else {
                res[i] = minHeap.peek();
            }
        }

        return res;
    }
}


