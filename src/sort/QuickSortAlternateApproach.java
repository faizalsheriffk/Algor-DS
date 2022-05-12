package sort;

public class QuickSortAlternateApproach {

    public static void main (String[] args){
        int[] uA = {89,89,2,3,34,67,89,90,22,89};
        QuickSortAlternateApproach q = new QuickSortAlternateApproach();
        q.quickSort(uA, 0, uA.length-1);

        q.display(uA);
    }

    public void quickSort(int[] uA, int low, int high){
        if(uA.length == 0)// santity check
            return;
        if(low < high) { // base condition: you need at-least two elements is required to swap
            int pivot = findPivot(uA, low, high);
            quickSort(uA, low, pivot -1);
            quickSort(uA,pivot+1, high);
        }
    }

    public int findPivot(int[] uA, int low, int high){
        int l = low -1;
        int pivot = uA[high];
        for(int i = low; i<high; i++){
            if(uA[i] <= pivot){ // make sure all the elements that you can control is on the left side of the pivot
                l++;
                swap (uA, l, i);
            }
        }
        swap(uA, l+1, high);
        return l+1;
    }

    public void swap(int[] arr, int a, int b){
        if (a== b){
            return;
        }
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    public void display(int[] uA){
        for(int i: uA) {
            System.out.println(i);
        }

    }

}
