class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        int countOfMeetings = 1;
        int meetings[][] = new int[n][3];
        for(int i = 0; i < n; i++) {
            int meeting[] = {start[i], end[i], i};
            meetings[i] = meeting;
        }
        Arrays.sort(meetings, (m1, m2) -> {
            if(m1[1] > m2[1]) return 1;
            else if(m1[1] < m2[1]) return -1;
            else return m1[2] - m2[2];
        });
        int prevEndTime = meetings[0][1];
        for(int i = 1; i < n; i++) {
            if(meetings[i][0] > prevEndTime) {
                countOfMeetings++;
                prevEndTime = meetings[i][1];
            }
        }
        return countOfMeetings;
    }
}
//Time: O(n log(n)), Space: O(n)