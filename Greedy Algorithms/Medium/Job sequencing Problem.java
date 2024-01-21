class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        int maxDeadline = 0, jobCount = 0, profit = 0;
        Arrays.sort(arr, (j1, j2) -> {
            return j2.profit - j1.profit;
        });
        for(int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, arr[i].deadline);
        }
        int jobs[] = new int[maxDeadline + 1];
        for(int i = 0; i < n; i++) {
            Job job = arr[i];
            for(int j = job.deadline; j > 0; j--) {
                if(jobs[j] == 0) {
                    jobs[j] = job.profit;
                    jobCount++;
                    profit += job.profit;
                    break;
                }
            }
        }
        return new int[]{jobCount, profit};
    }
}
//Time: O(n log(n) + (n * m)), Space: O(m)
//n = number of jobs
//m = max deadline among all jobs
//https://youtu.be/LjPx4wQaRIs

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/