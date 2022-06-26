package heap.simple;

import java.util.PriorityQueue;

public class KthLargest {

    private int heapSize;

    private PriorityQueue<Integer> heap;

    public KthLargest(int k, int[] nums) {
        this.heapSize = k;
        this.heap = new PriorityQueue<Integer>();
        for(int n:nums){
            heap.offer(n);
        }

        while(heap.size()>this.heapSize){
            heap.poll();
        }

        //  return heap.peek();
    }

    public int add(int val) {

        heap.offer(val);

        if(heap.size() > this.heapSize){
            heap.poll();
        }

        return heap.peek();

    }
}
