package intervals.medium;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumMeetingsII {

        public int minMeetingRooms(int[][] intervals) {

            int minMeeting = 1;
            if(intervals.length == 0){
                return minMeeting;
            }
            Arrays.sort(intervals, (a, b)->Integer.compare(a[0], b[0]));

            Queue<int[]> activeMeetingsQ = new PriorityQueue<int[]>((a, b)->Integer.compare(a[1],b[1]));

            activeMeetingsQ.add(intervals[0]);

            for(int i = 1; i<intervals.length; i++){

                if(activeMeetingsQ.peek()[1] <= intervals[i][0]){
                    activeMeetingsQ.poll();
                }
                activeMeetingsQ.add(intervals[i]);
                minMeeting = Math.max(minMeeting, activeMeetingsQ.size());
            }

            return minMeeting;
        }


//2-    15
//  4-9
//     9        29
//        16   23
}
