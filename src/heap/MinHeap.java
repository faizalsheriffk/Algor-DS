package heap;

public class MinHeap {

      class Node{
        private int priority;
        private String val;

        Node(int p, String v){
            this.priority = p;
            this.val = v;
        }

          public int getPriority() {
              return priority;
          }

          public String getVal() {
              return val;
          }
      }

    private int size;

    private Node[] items;

    public MinHeap(){

    }

    public MinHeap(int size){
        items = new Node[size];
    }

    public void add(int priority, String val){
        if(size == items.length){
            throw new IllegalStateException();
        }

        Node n = new Node(priority, val);
        items[size++] = n;

        bubbleUp();
    }

    public Node remove(){

        if(size == items.length){
            throw new IllegalStateException();

        }

        var r = items[0];

        items[0] = items[--size];

        bubbleDown();
        return r;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void bubbleUp(){
        var index = size-1;
        var parentIndex = getParentIndex(index);
        while(index > 0 && items[index].priority < items[parentIndex].priority){
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = getParentIndex(index);
        }

    }



    private int getParentIndex(int index){

        return ((2*index)-1)/2;
    }

    private void swap (int cIndex, int pIndex){
        var temp = items[cIndex];
        items[cIndex] = items[pIndex];
        items[pIndex] = temp;
    }

    private void bubbleDown(){
        var index = 0;
        while(index<size && isParentNotValid(index)) {

            var smallIndex = getSmallerChildIndex(index);
            if(smallIndex == index || smallIndex >= size)
                return;

            swap(smallIndex, index);
            index = smallIndex;

        }
    }

    private int getSmallerChildIndex(int pI){
        var rI = getRightIndex(pI);
        var lI = getLeftIndex(pI);

        if(lI >= size){
            return lI;
        }else if(rI >= size){
            return items[pI].priority > items[lI].priority ? lI:pI;
        }else if(
            items[pI].priority > items[lI].priority  ||
                    items[pI].priority > items[rI].priority){

            return items[lI].priority < items[rI].priority ? lI: rI;
        }
        return pI;
    }


    private boolean isParentNotValid(int pI){
        var rI = getRightIndex(pI);
        var lI = getLeftIndex(pI);

        if(lI >= size){
            return false;//parent has no child
        }else if(rI >= size){
            return items[pI].priority > items[lI].priority;
        }else{
            return items[pI].priority > items[lI].priority ||
                    items[pI].priority > items[rI].priority;
        }
    }

    private int getRightIndex(int pI){
        return (2*pI)+2;
    }

    private int getLeftIndex(int pI){
        return (2*pI)+1;
    }

}
