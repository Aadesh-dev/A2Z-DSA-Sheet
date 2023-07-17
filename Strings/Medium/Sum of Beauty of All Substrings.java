class Solution {
    public int beautySum(String s) {
        int sum = 0;
        for(int i=0; i<s.length() - 1; i++) {
            int arr[] = new int[26];
            for(int j=i; j<s.length(); j++) {
                int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
                arr[s.charAt(j) - 'a'] += 1;
                for(int k=0; k<arr.length; k++) {
                    if(arr[k] > 0) {
                        if(arr[k] < min) {
                            min = arr[k];
                        }
                        if(arr[k] > max) {
                            max = arr[k];
                        }
                    }
                }
                sum += max - min;
            }
        }
        return sum;
    }
}
//Time: O(26 * (n^2)), Space: O(26 * n)