package heap.simple;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());

        for(int stone:stones){
            maxHeap.offer(stone);
        }

        while(maxHeap.size() > 1){
            var a = maxHeap.poll();
            var b = maxHeap.poll();

            var sum = a- b;
            if(sum > 0){
                maxHeap.offer(sum);
            }


        }

        HashMap map = new HashMap();
        map.remove("c");


        return maxHeap.size()>0? maxHeap.peek():0;

    }
}
