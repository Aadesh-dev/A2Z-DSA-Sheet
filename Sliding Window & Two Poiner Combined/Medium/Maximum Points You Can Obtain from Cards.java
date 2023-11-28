class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int i = 0, j = cardPoints.length - k - 1, totalPoints = 0, sumOfCurrentWindow = 0, n = cardPoints.length, max = 0;
        for(int x = 0; x < n; x++) {
            totalPoints += cardPoints[x];
            if(x < n - k) sumOfCurrentWindow += cardPoints[x];
        }
        if(sumOfCurrentWindow == 0) return totalPoints;
        while(j < n) {
            max = Math.max(max, totalPoints - sumOfCurrentWindow);
            sumOfCurrentWindow -= cardPoints[i];
            i++;
            j++;
            if(j < n) sumOfCurrentWindow += cardPoints[j];
        }
        return max;
    }
}
//Time: O(n), Space: O(1)