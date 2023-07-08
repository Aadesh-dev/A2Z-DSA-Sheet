int[] findTwoElement(int arr[], int n) {
        long N = (long) n;
        Arrays.sort(arr);
        int repeated = 0, missing = 0;
        long sum = arr[0], expectedSum = (N * (N + 1)) / 2;
        for(int i=1; i<n; i++) {
            if(arr[i-1] == arr[i]) {
                repeated = arr[i];
            }
            sum+=arr[i];
        }
        if(sum > expectedSum) {
            missing = repeated - (int)(sum - expectedSum);
        } else {
            missing = repeated + (int)(expectedSum - sum);
        }
        return new int[]{repeated, missing};
    }

// Time: O(n logn + n) => O(n logn), Space: O(1)

int[] findTwoElement(int arr[], int n) {
        Arrays.sort(arr);
        int repeated = 0, missing = 0;
        for(int i=1; i<n; i++) {
            if(arr[i-1] == arr[i]) {
                repeated = arr[i];
            } else if(arr[i] - arr[i-1] > 1) {
                missing = arr[i-1] + 1;
            }
        }
        if(arr[0] > 1) {
            missing = 1;
        } else if(arr[n-1] < n) {
            missing = n;
        }
        return new int[]{repeated, missing};
    }

//Time: O(n logn + n) => O(n logn), Space: O(1)

class Solve {
    int[] findTwoElement(int arr[], int n) {
        Arrays.sort(arr);
        int repeated = 0, missing = 0;
        for(int i=0; i<n-1; i++) {
            if(arr[i] == arr[i+1]) {
                repeated = arr[i];
            }
            if(arr[i] != i+1 && missing==0 && arr[i+1] != i+1) {
                missing = i+1;
            }
        }
        if(arr[n-1] != n && missing == 0){
            missing = n;
        }
        return new int[]{repeated,missing};
    }
}

// Time: O(n logn + n) => O(n logn), Space: O(1)

// Easy Optimal:
class Solve {
    int[] findTwoElement(int arr[], int n) {
        long missing = 0, repeating = 0, S = 0, S2 = 0, N = (long) n;
        // x - y = S - SN
        // x2 - y2 = S2 - S2N
        long SN = (N * (N + 1)) / 2; 
        long S2N = (N * (N + 1) * (2 * N + 1)) / 6;
        for(int i=0; i<n; i++) {
            S += arr[i];
            S2 += (long) arr[i] * (long) arr[i];
        }
        long val1 = S - SN;
        long val2 = S2 - S2N;
        val2 = val2 / val1; // x + y = (S2 - S2N) / (x - y)
        repeating = (val1 + val2) / 2; // Solving simultaneous equations
        missing = repeating - val1; // Substituting x in x - y = S - SN to get y
        return new int[]{(int) repeating, (int) missing};

    }
}

// Time: O(n), Space: O(1)

// Hard Optimal:

int[] findTwoElement(int arr[], int n) {
        /* Will hold xor of all elements
       and numbers from 1 to n  */
        int xor1;
 
        /* Will have only single set bit of xor1 */
        int set_bit_no;
 
        int i, x = 0, y = 0;
 
        xor1 = arr[0];
 
        /* Get the xor of all array elements  */
        for (i = 1; i < n; i++)
            xor1 = xor1 ^ arr[i];
 
        /* XOR the previous result with numbers from
       1 to n*/
        for (i = 1; i <= n; i++)
            xor1 = xor1 ^ i;
 
        /* Get the rightmost set bit in set_bit_no */
        set_bit_no = xor1 & ~(xor1 - 1);
 
        /* Now divide elements into two sets by comparing
    rightmost set bit of xor1 with the bit at the same
    position in each element. Also, get XORs of two
    sets. The two XORs are the output elements. The
    following two for loops serve the purpose */
        for (i = 0; i < n; i++) {
            if ((arr[i] & set_bit_no) != 0)
                /* arr[i] belongs to first set */
                x = x ^ arr[i];
 
            else
                /* arr[i] belongs to second set*/
                y = y ^ arr[i];
        }
        for (i = 1; i <= n; i++) {
            if ((i & set_bit_no) != 0)
                /* i belongs to first set */
                x = x ^ i;
 
            else
                /* i belongs to second set*/
                y = y ^ i;
        }
        
        int res[] = new int[2];
        
        for (i = 0; i < n; i++) {
            if(arr[i] == x) {
                res[0] = x;
                res[1] = y;
            }
        }
        
        if(res[0] == 0) {
            res[0] = y;
            res[1] = x;
        }
        
        return res;
    }

// Time: O(5n) => O(n), Space: O(1)

// Good explanation of xor1 & ~(xor1 - 1):

// say the kth bit from right side is the first set bit in number 'x'. (x-1) will toggle every bit upto kth bit from right side. ~(x-1) will toggle every bit in (x-1).
// eventually every bit right of the k will become 0 and every bit left of k will become different which is in x and the number remaining would be a power of 2 which will have only one set bit.
// for example :
// x = 12 (1100)
// (x-1) = 11 (1011) [It will toggle every bit upto kth bit. here k = 3 (from right.)]
// ~ (x-1) = 4 (0100) [every bit right of the k is 0. So &ing it with x will set every bit to it's right to 0, Also every bit to it's left is either 0 or 1, but different from x, so &ing this will make them as 0]
// eventually x & ~(x-1) = 4. (power of 2, only 1 set bit.)






