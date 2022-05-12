package queue;

import java.lang.reflect.Array;
import java.util.Arrays;


public class PriorityQueue {


    private int[] pQueue;

    private int size = 0;
    private int count = 0;

    public PriorityQueue(int size){
        this.pQueue = new int[size];
        this.size = size;

    }



    //enqueue
    //1 2 5 6

    public void enQueue(Integer t){

        if(count == size){
            throw new IllegalStateException();
        }
        //precondition
//        if(count == 0){
//            pQueue[0] = t;
//            count++;
//            return;
//        }

        int temp = 0;
        for(int i =0; i<count; i++){
              if(pQueue[i] < t){
                continue;
            }else{
                temp = pQueue[i];
                pQueue[i] = t;
            }
        }
        if(temp!=0)
        pQueue[count] = temp;
        else
            pQueue[count] = t;

        if(count<=size)
        count++;


        System.out.println("Enqueue"+ Arrays.toString(pQueue)+"current count = "+count);
    }


    public Integer deQueue(){
        var t = pQueue[0];
        count --;
        System.out.println("Enqueue"+ Arrays.toString(pQueue)+"current count = "+count);
        return t;
    }

}
