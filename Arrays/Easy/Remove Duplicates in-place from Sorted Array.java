class Solution {
    int remove_duplicate(int A[],int N){
        int i=0;
        TreeSet<Integer> set=new TreeSet<>();
        for(int num:A) {
            set.add(num);
        }
        Iterator it=set.iterator();
        while(it.hasNext()) {
            A[i]=(Integer)it.next();
            i++;
        }
        return set.size();
    }
}

// Time: O(nlogn)+O(n), Space:O(n)
// O(n) - to add all elements of array to treeset
// O(nlogn) - all operations in treeset take O(log n) time. Here we are performing add operation n and retrieve operation n times
// so O(nlogn).

// Optimal:
// ----------
class Solution {
    int remove_duplicate(int A[],int N){
        int i=0;
        for(int j=1;j<A.length;j++) {
            if(A[j]!=A[i]) {
                i++;
                A[i]=A[j];
            }
        }
        return i+1;
    }
}

// Time:O(n), Space:O(1)

// Optimal and more readable:
// ----------------------------
int remove_duplicate(int A[],int N){
    int i=0, j=1;
    while(j<N) {
        if(A[i]!=A[j]) {
            A[i+1]=A[j];
            i++;
        }
        j++;
    }
    return i + 1;
}

//Time:O(n), Space:O(1)