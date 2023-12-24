import java.util.List;
public class Solution {
    public static int pop(List<Integer> heap) {
        if(heap.size() == 0) return -1;
        int res = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        int pos = 0;
        while(pos < heap.size() - 1) {
            int child1 = pos * 2 + 1;
            int child2 = pos * 2 + 2;
            int greaterChild = 0;
            if(child1 <= heap.size() - 1 && child2 <= heap.size() - 1) {
                greaterChild = heap.get(child1) > heap.get(child2) ? child1 : child2;
            } else if(child1 <= heap.size() - 1) {
                greaterChild = child1;
            } else if(child2 <= heap.size() - 1) {
                greaterChild = child2;
            } else break;
            
            if(heap.get(pos) < heap.get(greaterChild)) {
                int temp = heap.get(pos);
                heap.set(pos, heap.get(greaterChild));
                heap.set(greaterChild, temp);
                pos = greaterChild;
            } else {
                break;
            }
        }
        return res;
    }

    // Code Snippet of the push function:
    // public static void push(List<Integer> heap, int x) {
    //         heap.add(x);
    //
    //         // Position of the current inserted element.
    //         int pos = heap.size() - 1;
    //
    //         // Shifting the element up until it reaches the topmost node if it is larger than its parent.
    //         while (pos > 0) {
    //             int parent = (pos - 1) / 2;
    //             if (heap.get(pos) > heap.get(parent)) {
    //                 // Swapping the elements.
    //                 int temp = heap.get(parent);
    //                 heap.set(parent, heap.get(pos));
    //                 heap.set(pos, temp);
    //                 pos = parent;
    //             } else {
    //                 // As parent is larger, the element is now in its correct position.
    //                 break;
    //             }
    //         }
    //     }
}
//Time: O(log n), Space: O(1)
