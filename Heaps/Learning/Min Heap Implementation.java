import java.util.*;
public class Solution {

    static class MinHeap {

        List<Integer> heap;

        // Constructor for the class.
        MinHeap(int size) {
            heap = new ArrayList<>();
        }

        // Implement the function to remove minimum element.
        int extractMinElement() {
            if(heap.size() == 0) return -1;
            int res = heap.get(0);
            deleteElement(0);
            return res;
        }

        // Implement the function to delete an element.
        void deleteElement(int ind) {
            if(heap.size() == 0 || ind >= heap.size()) return;
            int res = heap.get(ind);
            heap.set(ind, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);
            int pos = ind;
            while(pos < heap.size() - 1) {
                int child1 = pos * 2 + 1;
                int child2 = pos * 2 + 2;
                int smallerChild = 0;
                if(child1 <= heap.size() - 1 && child2 <= heap.size() - 1) {
                    smallerChild = heap.get(child1) < heap.get(child2) ? child1 : child2;
                } else if(child1 <= heap.size() - 1) {
                    smallerChild = child1;
                } else if(child2 <= heap.size() - 1) {
                    smallerChild = child2;
                } else break;
                
                if(heap.get(pos) > heap.get(smallerChild)) {
                    int temp = heap.get(pos);
                    heap.set(pos, heap.get(smallerChild));
                    heap.set(smallerChild, temp);
                    pos = smallerChild;
                } else {
                    break;
                }
            }
            return;
        }

        // Implement the function to insert 'val' in the heap.
        void insert(int val) {
            heap.add(val);
    
            // Position of the current inserted element.
            int pos = heap.size() - 1;
    
            // Shifting the element up until it reaches the topmost node if it is smaller than its parent.
            while (pos > 0) {
                int parent = (pos - 1) / 2;
                if (heap.get(pos) < heap.get(parent)) {
                    // Swapping the elements.
                    int temp = heap.get(parent);
                    heap.set(parent, heap.get(pos));
                    heap.set(pos, temp);
                    pos = parent;
                } else {
                    // As parent is smaller, the element is now in its correct position.
                    break;
                }
            }
        }
    }
};
//Time: O(log n), Space: O(1)

//https://practice.geeksforgeeks.org/problems/implementation-of-priority-queue-using-binary-heap/1