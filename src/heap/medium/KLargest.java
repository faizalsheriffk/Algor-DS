package heap.medium;

import java.util.PriorityQueue;
import java.util.Queue;

public class KLargest {

    public int findKthLargest(int[] nums, int k) {

        // Arrays.sort(nums);
        //    return nums[nums.length-k];

        if(nums.length == 0){
            return -1;

        }

        Queue<Integer> minHeap = new PriorityQueue<Integer>();

        for(int i = 0; i<nums.length; i++){

            if(minHeap.size()<k){
                minHeap.offer(nums[i]);
            }else{

                if(minHeap.peek()<nums[i]){
                    minHeap.poll();
                    minHeap.offer(nums[i]);
                }
            }
        }
        return minHeap.peek();
    }
}
