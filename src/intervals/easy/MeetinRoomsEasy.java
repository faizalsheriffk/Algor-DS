package intervals.easy;

import java.util.Arrays;

public class MeetinRoomsEasy {

    public boolean canAttendMeetings(int[][] intervals) {

        //sorting took me some time

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));

        int prevStart = 0;
        int prevEnd = 0;

        for(int[] entry:intervals){
            if(prevEnd > entry[0 ]){
                return false;

            }

            prevStart = entry[0];
            prevEnd = entry[1];

        }



        return true;
    }
}
