package intervals.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        List<int[]> result = new ArrayList<int[]>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));

        if(intervals.length == 1){
            return intervals;
        }

        int[] prev = intervals[0];
        for(int i = 1; i < intervals.length; i++){

            if(prev[1] < intervals[i][0]){
                result.add(prev);
                prev = intervals[i];
            }else if(intervals[i][1] < prev[0]){
                result.add(intervals[i]);

            }else{
                prev[0] = Math.min(prev[0], intervals[i][0]);
                prev[1] = Math.max(prev[1], intervals[i][1]);
            }
        }
        result.add(prev);

        int[][] resultArray = new int[result.size()][2];

        return result.toArray(resultArray);
    }
}
