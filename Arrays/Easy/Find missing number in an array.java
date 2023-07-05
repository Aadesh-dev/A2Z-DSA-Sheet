public static int missingNumber(int A[], int N)
    {
         int expectedSum=0,actualSum=0,i;
         for(i=0;i<N-1;i++) {
             actualSum+=A[i];
             expectedSum+=i+1;
         }
         expectedSum+=i+1;
         return expectedSum-actualSum;
    }

// Time:O(n), Space:O(1)

// Smarter:
// -----------
public static int missingNumber(int A[], int N)

    {

         // Your code goes here

         int s=N*(N+1)/2;

         for(int i:A){

             s-=i;

         }

         return s;

    }
//Time:O(n), Space:O(1)