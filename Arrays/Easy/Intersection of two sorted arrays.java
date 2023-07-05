public static ArrayList<Integer> findArrayIntersection(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2, int m)
{
	ArrayList<Integer> list = new ArrayList<>();
	int i=0,j=0;
	while(i<n && j<m) {
		if(arr1.get(i)<arr2.get(j)) {
			i++;
		} else if(arr1.get(i)>arr2.get(j)) {
			j++;
		}
		else {
			list.add(arr1.get(i));
			i++;
			j++;
		}
	}
	return list;
}

// Time:O(n+m), Space:O(n+m)
// Here duplicate elements were allowed, but if they're not allowed there will be foll check before adding item in list:
// if(list.isEmpty() || list.get(list.size() - 1) != arr1.get(i))