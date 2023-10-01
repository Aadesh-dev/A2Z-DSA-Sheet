class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        Set<Integer> set = new HashSet<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Node node = head;
        while(node != null) {
            if(set.contains(target - node.data)) {
                ArrayList<Integer> tempList = new ArrayList<>();
                tempList.add(target - node.data);
                tempList.add(node.data);
                list.add(tempList);
            }
            set.add(node.data);
            node = node.next;
        }
        Collections.sort(list, (l1, l2) -> l1.get(0) - l2.get(0));
        return list;
    }
}
//Time: O(n) + O(n logn) => O(n logn), Space: O(n)

//2 pointer approach since DLL is sorted
class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Node left = head, right = head;
        while(right.next != null) {
            right = right.next;
        }
        while(left.data < right.data) {
            int sum = left.data + right.data;
            if(sum == target) {
                list.add(new ArrayList<Integer>(Arrays.asList(left.data, right.data)));
                left = left.next;
                right = right.prev;
            } else if(sum < target) {
                left = left.next;
            } else {
                right = right.prev;
            }
        }
        return list;
    }
}
//Time: O(2n) => O(n), Space: O(1)