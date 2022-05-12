package sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {

    public static void main(String args[]) {
       int[] unsoredArray = {2,1,4,5,7,3,1,3,5,0};
       int[] sortedArray = new MergeSort().mergeSort(unsoredArray);

       displayArray(sortedArray);
    }




    public int[] mergeSort(int[] array) {

        //sanity check

        if (array.length == 0 || array == null) {
            return array;
        }

        if (array.length > 2) {
            int[] lA = Arrays.copyOf(array, array.length/2);
            int[] rA = Arrays.copyOfRange(array, array.length/2, array.length-1);
            int[] lSA = mergeSort(lA);
            int[] rSA = mergeSort(rA);

            return merge(lSA, rSA);
        }else{
            //base cases
            if(array.length == 2){
                if(array[0] > array[1]){
                    return swap(array);
                }else {
                    return array;
                }
            }else{
                return  array;
            }
        }
    }



    private int[] merge(int[] lSA, int[] rSA) {

        int[] res = new int[lSA.length+rSA.length];
        int i =0;
        int j =0;
        int k = 0;
        while(i < lSA.length && j < rSA.length){

            if(lSA[i] <= rSA[j]){
                res[k] = lSA[i];
                i++;
                k++;
            }else {
                res[k] = rSA[j];
                j++;
                k++;
            }
        }

        //left out items of the left array
        while (i < lSA.length){
            res[k] = lSA[i];
            k++;
            i++;
        }

        //left out items on the right array
        while (j < rSA.length){
            res[k] = rSA[j];
            k++;
            j++;
        }
        return res;
    }

    private int[] swap(int[] array) {
     int temp = array[0];
     array[0] = array[1];
     array[1] = temp;
     return array;
    }

    private static void displayArray(int[] sortedArray) {
     for(int i: sortedArray){
         System.out.println(i);
     }
    }

}
