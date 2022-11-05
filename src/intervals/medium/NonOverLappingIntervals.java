package intervals.medium;

import java.util.Arrays;

public class NonOverLappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {

        if(intervals.length == 1){
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));

        int[] prev = intervals[0];
        int overlap = 0;

        for(int i = 1; i<intervals.length; i++){

            if(prev[1] <= intervals[i][0]){
                prev = intervals[i];
            }else if(intervals[i][1] <= prev[0]){
                continue;
            }else{
                overlap++;

                prev[0] = Math.min(prev[0], intervals[i][0]);
                prev[1] = Math.min(prev[1], intervals[i][1]);

            }
        }
        return overlap;
    }
}
