package sort;

public class QuickSort {

    public static void main(String[] args){
        int[] unsortedArray = {89,89,2,3,34,67,89,90,22,89};
        QuickSort q = new QuickSort();
        q.quickSort(unsortedArray, 0, unsortedArray.length-1);
        for(int i: unsortedArray){
            System.out.println(i);
        }

    }

    public int[] quickSort(int[] unsortedArray, int low, int high){

        //sanity check
        if(unsortedArray.length == 0){
            return unsortedArray;
        }

        if(low < high) {// you need at-least two elements to run this algo

            int pivot = pivotize(unsortedArray, low, high);

            quickSort(unsortedArray, low, pivot - 1);
            quickSort(unsortedArray, pivot + 1, high);
            int[] sortedArray = unsortedArray;
            return sortedArray;
        }
        return unsortedArray;
    }


    public int pivotize(int[] unsortedArray, int low, int high){
        int l = low-1;
        int p = unsortedArray[high];
        int temp = 0;

        for(int i = low; i<=high-1; i++){
            if(unsortedArray[i] < p){
                l++;
                swap(unsortedArray, l, i);

            }
        }
        swap(unsortedArray, l+1, high);
        return l+1;
    }

    private void swap(int[] unsortedArray, int l, int i) {
        if(l == i){
            //don't swap
            return;
        }
        int temp;
        temp = unsortedArray[l];
        unsortedArray[l] = unsortedArray[i];
        unsortedArray[i] = temp;

    }


}
