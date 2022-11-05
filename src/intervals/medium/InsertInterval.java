package intervals.medium;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {



//This is the solution that I came up with with the algorithm that I had in mind but the solution below depicts my actual thought process
//     public int[][] insert(int[][] intervals, int[] newInterval) {

//          List<int[]> result = new ArrayList<int[]>();

//         if(intervals.length == 0){
//             intervals = new int[1][2];
//             intervals [0] = newInterval;
//             return intervals;
//         }else if(intervals.length == 1){
//              if(newInterval[0] > intervals[0][1]){
//                         //new entry
//                         result.add(intervals[0]);
//                         result.add(newInterval);
//              }else{
//                    int[] res = new int[2];
//                    res[0] = Math.min(intervals[0][0], newInterval[0]);
//                    res[1] = Math.max(intervals[0][1], newInterval[1]);
//                  result.add(res);
//              }
//             return transformToIntArray(result);
//         }


//         boolean isNewIntervalPosLocated = false;
//         int[] prev = intervals[0];
//         result.add(prev);
//         for(int i = 1; i < intervals.length; i++){

//             if(!isNewIntervalPosLocated){
//                 if(newInterval[0] > intervals[i][0]){

//                     prev = intervals[i];
//                     result.add(prev);
//                     continue;
//                 }else{
//                     if(newInterval[0] > prev[1]){
//                         //new entry
//                         result.add(newInterval);
//                     }else{
//                         //merge
//                         int[] res = new int[2];
//                         res[0] = Math.min(prev[0], newInterval[0]);
//                         res[1] = Math.max(prev[1], newInterval[1]);
//                         int lastIndex = result.size() -1;
//                         result.remove(lastIndex);
//                         result.add(res);
//                         prev = res;
//                         isNewIntervalPosLocated = true;

//                     }
//                      i--; // this is critical as you need to reprocess the currnet element
//                 }
//             }else{
//                 //merge
//                 if(prev[1]<intervals[i][0]){

//                     //copy the rest of the array to result;
//                     copy(result, intervals, i);
//                     break;
//                 }else{

//                     merge(result, intervals, i);
//                     prev = result.get(result.size()-1);
//                 }


//             }
//         }

//         return transformToIntArray(result);
//     }


//     private void copy(List<int[]> result, int[][] intervals, int index){

//         for(int i = index; i<intervals.length; i++){
//             result.add(intervals[i]);
//         }
//     }

//     private void merge(List<int[]> result, int[][] intervals, int index){
//         int lastIndex = result.size()-1;
//         int res[] = result.get(lastIndex);

//         res[0] = Math.min(res[0], intervals[index][0]);
//         res[1] = Math.max(res[1], intervals[index][1]);

//         result.remove(lastIndex);

//         result.add(res);


//     }

//     private int[][] transformToIntArray(List<int[]> res){
//     int[][] result = new int[res.size()][2];

//     for(int i = 0; i<res.size();i++){
//         var cur = res.get(i);
//         result[i][0] = cur[0];
//         result[i][1] = cur[1];
//     }
//     return result;
//     }


    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int[] prev = newInterval;

        for(int[] current:intervals){
            if(prev[1] < current[0]){ // if the prev is less than the current item - new entry before current;
                result.add(prev);
                prev = current;
            }else if(current[1] < prev[0]){
                //traverse untill you find a position
                result.add(current);
            }else{
                //merge situation, the merged one will be the new prev
                prev[0] = Math.min(prev[0], current[0]);
                prev[1] = Math.max(prev[1], current[1]);
            }
        }

        result.add(prev);

        int[][] resultArray = new int[result.size()][2];
        result.toArray(resultArray);
        return resultArray;
    }
}

