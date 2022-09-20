package dynamicprogramming.archive;

import java.util.Arrays;
import java.util.TreeMap;

public class MinimumDifficultyJob {

    private int n, d;
    private int[][] memo;
    private int[] jobDifficulty;
    private int[] hardestJobRemaining;

    private int dp(int i, int day) {
        // Base case, it's the last day so we need to finish all the jobs

        //3,6   1       4
        //3     6,1     4
        //3     6       1,4
        
        if (day == d) {
            return hardestJobRemaining[i];
        }

        if (memo[i][day] == -1) {
            int best = Integer.MAX_VALUE;
            int hardest = 0;
            // Iterate through the options and choose the best
            for (int j = i; j < n - (d - day); j++) {
                hardest = Math.max(hardest, jobDifficulty[j]);
                // Recurrence relation
                best = Math.min(best, hardest + dp(j + 1, day + 1));
            }
            memo[i][day] = best;
        }

        return memo[i][day];
    }

    //3,6,1,4
    //3

    public int minDifficulty(int[] jobDifficulty, int d) {
        n = jobDifficulty.length;
        // If we cannot schedule at least one job per day,
        // it is impossible to create a schedule
        if (n < d) {
            return -1;
        }

        hardestJobRemaining = new int[n];
        int hardestJob = 0;
        for (int i = n - 1; i >= 0; i--) {
            hardestJob = Math.max(hardestJob, jobDifficulty[i]);
            hardestJobRemaining[i] = hardestJob;
        }

        // Initialize memo array with value of -1.
        memo = new int[n][d + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        this.d = d;
        this.jobDifficulty = jobDifficulty;
        return dp(0, 1);


    }


}


