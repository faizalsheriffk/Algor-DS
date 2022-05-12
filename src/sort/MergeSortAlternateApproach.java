import java.util.Arrays;

public class MergeSortAlternateApproach {

    public static void main (String[] args){
        int[] unsortedArr = {2,7,8,9,6,9,8,2,3,5,7,3};
        unsortedArr = new MergeSortAlternateApproach().mergeSort(unsortedArr);

        for (int i : unsortedArr){
            System.out.println(i);
        }
    }


    public int[] mergeSort(int[] unsortedArr){

        //sanity check
        if(unsortedArr.length == 0){
            return unsortedArr;
        }

        else if(unsortedArr.length>2) {
            int[] lA = Arrays.copyOfRange(unsortedArr, 0, unsortedArr.length / 2);
            int[] rA = Arrays.copyOfRange(unsortedArr, unsortedArr.length / 2, unsortedArr.length);
            int[] newA = new int[lA.length + rA.length];
            int[] lSA = mergeSort(lA);
            int[] rSA = mergeSort(rA);
            return merge(lSA, rSA, newA);
        }
        //base cases !!
        else if(unsortedArr.length == 2){
            if(unsortedArr[0] > unsortedArr[1]){
                return swap(unsortedArr);
            }else {
                return unsortedArr;
            }
        }else{
            return unsortedArr;
        }

    }


    public int[] merge(int[] lSA, int[] rSA, int[] newA){

        int l = 0;
        int r = 0;
        int k = 0;

        while (l < lSA.length && r< rSA.length){
            if(lSA[l] <= rSA[r]){
                newA[k] = lSA[l];
                l++;
            }else{
                newA[k] = rSA[r];
                r++;
            }
            k++;
        }


            //copy the right array to the new array utiling native library
            while (r<rSA.length){
                newA[k] = rSA[r];
                r++;
                k++;
            }

            //copy the left array to the new aray
            while(l<lSA.length){
                newA[k] = lSA[l];
                l++;
                k++;
            }

        return newA;
    }
    public int[] swap(int[] arr){
        if(arr.length<2){
            return arr;
        }
        int temp = arr[1];
        arr[1] = arr[0];
        arr[0] = temp;
        return arr;
    }
}
