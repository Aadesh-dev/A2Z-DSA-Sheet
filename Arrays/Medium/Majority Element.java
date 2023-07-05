//Not brute(O(n^2)), but better:

static int majorityElement(int a[], int size)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<size; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            if(map.get(a[i]) > size/2) return a[i];
        }
        return -1;
    }
// Time: O(n), Space: O(n)

// Optimal:
static int majorityElement(int a[], int size)
    {
        int element=0, count=0;
        for(int i=0; i<size; i++) {
            if(count == 0) {
                element = a[i];
            }
            if(a[i] == element) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for(int i=0; i<size; i++) {
            if(a[i] == element) {
                count++;
            }
        }
        if(count > size/2) {
            return element;
        }
        return -1;
    }
// Time: O(n), Space: O(1)


// Alternative Optimal:
static int majorityElement(int a[], int size)
    {
        int element=a[0], count=1;
        for(int i=1; i<size; i++) {
            if(count == 0) {
                element = a[i];
            }
            if(a[i] == element) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for(int i=0; i<size; i++) {
            if(a[i] == element) {
                count++;
            }
        }
        if(count > size/2) {
            return element;
        }
        return -1;
    }
// Time: O(n), Space: O(1)

// The main idea here is that if count goes to 0 then in that particular sub-array, the current element can’t be occurring greater than n/2 times because there exist at least n/2 other elements(n here being the size of the sub-array and not of the whole array) which are causing the count to go to 0. 
// The second loop is not required if the question states that there will always be a majority element.
