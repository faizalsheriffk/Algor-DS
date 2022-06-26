package heap.medium;

import java.util.*;

/**
 * This problem was bit challenging. This problem is an example when things don't go your way,
 * back up and start fresg
 */

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        //O(N)
        for(Character task : tasks){
            map.put(task, map.getOrDefault(task,0)+1);
        }

        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b-a));

        maxHeap.addAll(map.values());
        int interval = 0;

        while(!maxHeap.isEmpty()){

            List<Integer> waitingList = new ArrayList<Integer>();
            int coolT = n+1;

            //this formulae is key
            while(coolT>0 && !maxHeap.isEmpty()){

                var freq = maxHeap.poll();
                freq--;
                interval++;

                if(freq>0)
                    waitingList.add(freq);

                coolT--;
            }
            maxHeap.addAll(waitingList);
            //heap is not empty still and CPU needs to wait till remaining cool off period
            if(!maxHeap.isEmpty()){
                interval += coolT;
            }

        }

        return interval;

    }

}
