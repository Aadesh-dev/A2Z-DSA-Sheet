class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int trains = 1, platforms = 1, i = 1, j = 0;
        while(i < n) {
            trains++;
            while(dep[j] < arr[i]) {
                j++;
                trains--;
            }
            platforms = Math.max(platforms, trains);
            i++;
        }
        return platforms;
    }
    
}
//Time: O(2(n log(n)) + 2n) => O(n log(n)), Space: O(1)
//https://youtu.be/dxVcMDI7vyI
//Example:
// {0900, 0940, 0950, 1100, 1500, 1800}
// {0910, 1120, 1130, 1200, 1900, 2000}