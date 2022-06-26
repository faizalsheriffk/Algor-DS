package heap.medium;

import java.util.PriorityQueue;
import java.util.Queue;

public class kClosestPoints {

    public int[][] kClosest(int[][] points, int k) {

        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1]-a[1]);


        //addiing to queue
        for(int i = 0; i<points.length; i++){

            int[] entry = {i, euclidDist(points[i])};

            if(maxHeap.size() == k && entry[1] < maxHeap.peek()[1]){
                maxHeap.poll();
                maxHeap.offer(entry);
            }else{
                maxHeap.offer(entry);
            }

            // if(maxHeap.size()<k){
            //     maxHeap.offer(entry);
            // }else if(entry[1] < maxHeap.peek()[1]){
            //     maxHeap.poll();
            //     maxHeap.offer(entry);
            // }
        }

        //collect results

        int[][] res = new int[k][2];

        for(int i=0; i<k; i++){
            res[i] = points[maxHeap.poll()[0]];
        }

        return res;
    }


    private int euclidDist(int[] point){
        return (point[0]*point[0])+(point[1]*point[1]);
    }
}
