package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DynamicArray {
    public static void main (String[] args){
        int[] a = {1,2,3,4,65,78,45,32};
        int[] b = {2,3,4,5,6,78,45,2,46};
        int[] iA = new DynamicArray().intersect(a,b);
        System.out.println(Arrays.toString(iA));
    }

    public int[] intersect(int[] a, int[] b){

            if(a.length == 0 || b.length == 0){
                return new int[0];
            }else{
                int l = a.length<= b.length ? a.length:b.length;
                Set<Integer> interA = new HashSet<Integer>();


                for(int i: a){
                    for (int j: b){
                        if(i==j){
                            interA.add(i);
                        }
                    }
                }

               int[] arr = new int[interA.size()];int k = 0;

               for(int e: interA){
                    arr[k] = e;
                    k++;
                }

                return arr;
            }

        }
}
