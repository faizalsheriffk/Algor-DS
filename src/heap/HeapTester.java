package heap;

import heap.MinHeap.Node;

import java.util.HashMap;

public class HeapTester {

    public static void main(String[] args){
        Heap h = new Heap(5);
        h.insert(1);
        h.insert(2);
        h.insert(6);
        h.insert(4);
        h.insert(5);
        h.display();


        while(!h.isEmpty()){
            System.out.println(h.remove());
        }
        int[] arr = {1,23,45,2,56,675,11124};
        HeapTester t = new HeapTester();
        System.out.println("++++");
        System.out.println(t.findKLargest(arr,3));

        int[] heap = {54,41,32,27,31,28};

        System.out.println("++++");
        System.out.println("result"+t.isMaxHeap(heap));


        MinHeap minHeap = new MinHeap(5);
        minHeap.add(1,"hello");
        minHeap.add(45,"how");
        minHeap.add(64, "you");
        minHeap.add(48, "are");

        while(!minHeap.isEmpty()){
            var node = minHeap.remove();
            System.out.println("removed"+node.getPriority());
        }

    }

    public int findKLargest(int[] arr, int k){
        if(arr.length<=0)
            throw new IllegalStateException();

        var kLar = 0;
        Heap h = new Heap(arr.length);

        for(int i=0; i < arr.length; i++){
            h.insert(arr[i]);
        }

        for(int i=0; i < k; i++){
            kLar = h.remove();
        }

        return kLar;
    }


    /**
     * Remember to check for length -1 as it does not represent actual size !!
     * @param heap
     * @return
     */
    public boolean isMaxHeap(int[] heap){

         if(heap.length == 0){
             return false;
         }

        for(int i =0; i< heap.length; i++){
            var leftIndex = (2*i)+1;
            var rightIndex = (2*i)+2;
            var parentIndex = ((2*i)-1)/2;
            if(leftIndex >= heap.length -1 || parentIndex >= heap.length-1){
                break;
            }else if(rightIndex >= heap.length-1 && heap[parentIndex] < heap[leftIndex]){
                return false;
            }
            else if(heap[parentIndex] < heap[leftIndex]
                    || heap[parentIndex] < heap[rightIndex]){
                return false;
            }

        }
    return true;

    }
}
