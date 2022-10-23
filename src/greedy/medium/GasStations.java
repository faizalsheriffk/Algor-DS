package greedy.medium;

import java.util.Arrays;

public class GasStations {

    /*
     * This solution relies on couple of things
     * It has a unique path / solution - a very important clue
     *   if there is one solution sum of gas should be >= sum of cost - basic math
     *       if we pass the above we know one solution exists, we just need to find the starting part
     *           How do we find the starting point?
     *               The clue: circular path is a confusing clue or intentionally misleading clue.
     *                       All we need to do is return a start index that does not reduce the total below zero
     *
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {


        if(Arrays.stream(gas).sum() < Arrays.stream(cost).sum()){
            return -1;
        }

        int total = 0;
        int startIndex = 0;

        for(int i = 0; i<gas.length; i++){
            total += gas[i] - cost[i];

            if(total < 0){
                startIndex = i+1;
                total = 0;
            }

        }

        return startIndex;
    }

    //[-2,-2,-2,3,3]

    //I came up with my own sometime with a TLE
//     public int canCompleteCircuit(int[] gas, int[] cost) {

//         int[] netCost = new int[gas.length];

//         Queue<Integer> q = new PriorityQueue<Integer>();
//         int netSum = 0;
//         for(int i = 0; i<gas.length; i++){
//             netCost[i] =  gas[i] - cost[i];

//             if(netCost[i] > 0){
//                 q.offer(i);
//             }
//             netSum += netCost[i];
//         }

//         if(netSum < 0){
//             return -1;
//         }

//         //special case
//         if(netCost.length == 1){
//             if(netCost[0]>=0)
//                 return 0;
//             else
//                 return -1;
//         }

//         while(!q.isEmpty()){

//             var startIndex = q.poll();
//             var index = startIndex;
//             var distance = 0;
//                 while(true){

//                     distance = distance+netCost[index];

//                     if(distance < 0){
//                         break;
//                     }

//                     if(index >= netCost.length-1){
//                         index = index-netCost.length;
//                     }

//                     if(index == startIndex -1){
//                         return startIndex;
//                     }

//                     index++;
//                 }
//         }

//         return -1;

//     }
}
