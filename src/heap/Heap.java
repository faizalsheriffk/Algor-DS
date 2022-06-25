package heap;

public class Heap {

    private int[] items;
    private int size;


    public Heap() {

    }

    /**
     *
     * @param size
     */
    public Heap(int size) {
        items = new int[size];
    }


    /**
     * Insert the data
     *
     * @param n
     */
    public void insert(int n) {
        if (size > items.length) {
            throw new IllegalStateException("Size overflow exception");
        }
        items[size++] = n;
        bubbleUp();
    }

    /**
     * Removes the root
     */
    public int remove() {
        if (size <= 0) {
            throw new IllegalStateException("Heap is empty");
        }
        var rV = items[0];
        items[0] = items[--size];
        bubbleDownV();
        return rV;
    }

    public boolean isEmpty(){
        return size<=0;
    }

    /**
     * Displays the Heap Content
     */
    public void display() {
        System.out.println("================");
        for (int i = 0; i < size; i++) {
            System.out.println(items[i]);
        }
        System.out.println("================");
    }


    private void bubbleUp() {
        var index = size - 1;
        var parentIndex = getParentIndex(index);
        while (index > 0 && items[parentIndex] < items[index]) {

            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = getParentIndex(index);

        }

    }


    private void bubbleDownV(){
        var index = 0;

        while(index < size && isParentNotValid(index)){

            var leftI = getLeftChildIndexV(index);
            var rightI = getRightChildIndexV(index);

            if(leftI >= size)
                return;

            else if (rightI >= size && items[index] < items[leftI]){
                swap(leftI, index);
            }else if(items[index] < (items[leftI]>items[rightI]?items[leftI]:items[rightI])){
                var cIndex = (items[leftI]>items[rightI]?leftI:rightI);
                swap(cIndex,index);
            }

        }
    }


    private boolean isParentNotValid(int index){

        if(index<0 && index >= size){
            return false;
        }

        var leftI = getLeftChildIndexV(index);
        var rightI = getRightChildIndexV(index);

        if(leftI >= size)
            return false;
        else if (rightI >= size){
            return items[index] < items[leftI];
        }else{
            return items[index] < (items[leftI]>items[rightI]?items[leftI]:items[rightI]);

        }

    }

    private void bubbleDown() {
        var index = 0;

        while (index < size && !isParentValid(index)) {
            //swap values
            int biggerChildIndex = getBiggerChildIndex(index);
            //set index = current parent index
            if (biggerChildIndex == -1)
                return;

            swap(index, biggerChildIndex);
            index = biggerChildIndex;

        }
    }


    private int getParentIndex(int index) {
        //Note: Any arithimetic operation close it with bracket

        var parentIndex = (index - 1) / 2;
        return parentIndex;
    }

    private void swap(int cIndex, int pIndex) {
        int temp = items[cIndex];
        items[cIndex] = items[pIndex];
        items[pIndex] = temp;
    }



    private int getBiggerChildIndex(int index) {


        var leftIndex = getLeftChildIndex(index);
        var rightIndex = getRightChildIndex(index);

        if (isParentWithTwoKids(index)) {
            return items[leftIndex] > items[rightIndex] ? leftIndex : rightIndex;
        } else {

            return leftIndex > 0 ? leftIndex : -1;
        }


    }

    private boolean isParentWithTwoKids(int index) {
        var leftIndex = getLeftChildIndex(index);
        var rightIndex = getRightChildIndex(index);

        if (leftIndex > 0 && rightIndex > 0) {
            return true;
        }

        return false;
    }

    private boolean isParentValid(int index) {


        if (isParentWithTwoKids(index)) {
            if (items[index] >= items[getLeftChildIndex(index)] && items[index] >= items[getRightChildIndex(index)]) {
                return true;
            } else {
                return false;
            }
        } else if (getLeftChildIndex(index) > 0) {
            return items[index] >= items[getLeftChildIndex(index)];
        } else {
            //no child
            return false;
        }

    }


    private int getLeftChildIndex(int index) {

        var leftIndex = (2 * index) + 1;
        return (leftIndex < size) ? leftIndex : -1;
    }

    private int getRightChildIndex(int index) {
        var rightIndex = (2 * index) + 2;
        return (rightIndex < size) ? rightIndex : -1;
    }

    private int getLeftChildIndexV(int index) {

        return (2 * index) + 1;

    }

    private int getRightChildIndexV(int index) {
        return (2 * index) + 2;
    }

}
