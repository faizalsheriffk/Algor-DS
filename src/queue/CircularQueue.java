package queue;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class CircularQueue<T> {


    private T cQueue[];
    private int front = 0;
    private int rear = 0;

    private int size = 0;


    private CircularQueue(){

    }

    public CircularQueue(Class<T> clazz, int size){
        this.cQueue  = (T[]) Array.newInstance(clazz, size);
        this.size = size;
    }

    public void enQueue(T t){
        //0,1,2,3,4
        //1,2,3,4,5
        //  t r

        //quue full case
        if((front == 0 &&  rear >= cQueue.length) || (!(front == 0 && rear==0) && (front-rear == 0 ))){
            //queue full
            throw new IllegalStateException();
        }else if((front == 0 && rear == 0) || front-rear % cQueue.length != 0){

            if(rear >= cQueue.length && front!= 0){
                rear = 0;
            }

            cQueue[rear] = t;

            rear ++;

            if(rear == front)
                rear --;



        }

        System.out.println("Enqueue"+Arrays.toString(cQueue)+"current top = "+front+" rear = "+rear);
    }


    public T dequeue(){
        if(front == rear){
            throw new IllegalStateException("queue is empty");
        }

        var v = cQueue[front];

        front++;

        if(front >= cQueue.length ){
            front = 0;
        }

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
