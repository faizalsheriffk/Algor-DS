package tree;

public class TreeNodeV2 {

    private Integer val;
    private TreeNodeV2 left;
    private TreeNodeV2 right;

    public TreeNodeV2(){

    }
    public TreeNodeV2(Integer value){
        this.val = value;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public TreeNodeV2 getLeft() {
        return left;
    }

    public void setLeft(TreeNodeV2 left) {
        this.left = left;
    }

    public TreeNodeV2 getRight() {
        return right;
    }

    public void setRight(TreeNodeV2 right) {
        this.right = right;
    }
}
