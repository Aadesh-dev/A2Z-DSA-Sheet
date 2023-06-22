public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        ArrayList<Integer> list=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        int i=0,j=0,main=0;
        while(i<n && j<m) {
            if(arr1[i]<arr2[j]) {
                if(!map.containsKey(arr1[i])) {
                    list.add(arr1[i]);
                    map.put(arr1[i],arr1[i]);
                }
                i++;
            } else {
                if(!map.containsKey(arr2[j])) {
                    list.add(arr2[j]);
                    map.put(arr2[j],arr2[j]);
                }
                j++;
            }
        }
        while(i<n) {
            if(!map.containsKey(arr1[i])) {
                    list.add(arr1[i]);
                    map.put(arr1[i],arr1[i]);
                };
            i++;
        }
        while(j<m) {
            if(!map.containsKey(arr2[j])) {
                    list.add(arr2[j]);
                    map.put(arr2[j],arr2[j]);
                };
            j++;
        }
        return list;
    }
// Can also be done using HashSet.
    
// Time Compleixty : O( (m+n)log(m+n) ) . Inserting a key in map takes logN times, where N is no of elements in map. At max map can store m+n elements {when there are no common elements and elements in arr,arr2 are distntict}. So Inserting m+n th element takes log(m+n) time. Upon approximation across insertion of all elements in worst it would take O((m+n)log(m+n) time.

// Space Complexity : O(m+n)

// Optimal:
// ------------
public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        ArrayList<Integer> list=new ArrayList<>();
        int i=0,j=0,main=0,key=arr1[0];
        while(i<n && j<m) {
            if(arr1[i]<arr2[j]) {
                list.add(arr1[i]);
                key=arr1[i];
                while(i<n && arr1[i]==key) i++;
            } else if(arr2[j]<arr1[i]) {
                list.add(arr2[j]);
                key=arr2[j];
                while(j<m && arr2[j]==key) j++;
            } else {
                list.add(arr1[i]);
                key=arr1[i];
                while(i<n && arr1[i]==key) i++;
                key=arr2[j];
                while(j<m && arr2[j]==key) j++;
            }
        }
        while(i<n) {
            list.add(arr1[i]);
            key=arr1[i];
            while(i<n && arr1[i]==key) i++;
        }
        while(j<m) {
            list.add(arr2[j]);
            key=arr2[j];
            while(j<m && arr2[j]==key) j++;
        }
        return list;
    }
// Time Complexity: O(m+n), Because at max i runs for n times and j runs for m times. When there are no common elements in arr1 and arr2 and all elements in arr1, arr2 are distinct. 

// Space Complexity : O(m+n) 

// Smarter:
// -----------
static ArrayList<Integer> FindUnion(int arr1[], int arr2[], int n, int m) {
   int i = 0, j = 0; // pointers
  ArrayList<Integer > Union=new ArrayList<>(); // Uninon vector
  while (i < n && j < m) {
    if (arr1[i] <= arr2[j]) // Case 1 and 2
    {
      if (Union.size() == 0 || Union.get(Union.size()-1) != arr1[i])
        Union.add(arr1[i]);
      i++;
    } else // case 3
    {
      if (Union.size() == 0 || Union.get(Union.size()-1) != arr2[j])
        Union.add(arr2[j]);
      j++;
    }
  }
  while (i < n) // IF any element left in arr1
  {
    if (Union.get(Union.size()-1) != arr1[i])
      Union.add(arr1[i]);
    i++;
  }
  while (j < m) // If any elements left in arr2
  {
    if (Union.get(Union.size()-1) != arr2[j])
      Union.add(arr2[j]);
    j++;
  }
  return Union;
}

// Time Complexity: O(m+n), Because at max i runs for n times and j runs for m times. When there are no common elements in arr1 and arr2 and all elements in arr1, arr2 are distinct. Best case is also O(m+n).

// Space Complexity : O(m+n) 