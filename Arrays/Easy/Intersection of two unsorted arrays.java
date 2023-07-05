//Leetcode:
public int[] intersection(int[] nums1, int[] nums2) {
    Integer[] nums3=IntStream.of( nums1 ).boxed().toArray( Integer[]::new );
    Integer[] nums4=IntStream.of( nums2 ).boxed().toArray( Integer[]::new );
    List<Integer> list1=new ArrayList<>();
    List<Integer> list2=new ArrayList<>();
    Collections.addAll(list1,nums3);
    Collections.addAll(list2,nums4);
    list1.retainAll(list2);
    Set<Integer> set = new HashSet<>(list1);
    int[] res=set.stream().mapToInt(i->i).toArray();
    return res;
}
//Time:O(nums1.length * nums2.length)(multiplication due to retailAll), Space:O(nums1.length+nums2.length)

//GFG:
public static int NumberofElementsInIntersection(int a[], int b[], int n, int m) {
    Set<Integer> set=new HashSet<>();
    Set<Integer> inputSet=new HashSet<>();
    int[] smallerArr = n<m ? a : b;
    int[] biggerArr = n<m ? b : a; // so that if both lengths are same, same array won't get selected twice
    for(int i=0;i<smallerArr.length;i++) {
        inputSet.add(smallerArr[i]);
    }
    for(int i=0;i<biggerArr.length;i++) {
        if(inputSet.contains(biggerArr[i])) set.add(biggerArr[i]);
    }
    return set.size();
}
// Time:O(n+m), Space:O(min(n,m))

// https://www.geeksforgeeks.org/find-union-and-intersection-of-two-unsorted-arrays/