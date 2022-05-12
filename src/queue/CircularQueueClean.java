package queue;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CircularQueueClean<T> {


    private T cQueue[];
    private int front = 0;
    private int rear = 0;
    private int size = 0;
    private int count = 0;


    private CircularQueueClean(){

    }

    public CircularQueueClean(Class<T> clazz, int size){
        this.cQueue  = (T[]) Array.newInstance(clazz, size);
        this.size = size;
    }

    public void enQueue(T t){
        //0,1,2,3,4
        //1,2,3,4,5
        //  t r

        //quue full case
        if(count == cQueue.length){
            //queue full
            throw new IllegalStateException();
        }else {

            cQueue[rear] = t;
            rear = (rear+1)%cQueue.length;
            count++;
        }

        System.out.println("Enqueue"+Arrays.toString(cQueue)+"current top = "+front+" rear = "+rear);
    }


    public T dequeue(){

        var v = cQueue[front];
        cQueue[front] = null;

        front = (front+1) % cQueue.length;

        count--;

        System.out.println(Arrays.toString(cQueue)+"current top = "+front+" rear = "+rear);
        return v;
    }

    //1,2,3,4,0,0

//    public T deQueue(T t){
//
//        if(front!=rear){
//            T val = cQueue[front];
//            front++;
//            return val;
//        }else{
//            return null;
//        }
//    }


    //1,2,3,4,5,6
    //0,2,3,4,5,6

}
