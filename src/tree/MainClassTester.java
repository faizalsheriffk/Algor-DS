package tree;

public class MainClassTester {


    private TreeNodeV2 node;
    private TreeNodeV2 node2;
    public static void main (String args[]){
        MainClassTester tester = new MainClassTester();
        int[] arr = {1,4,2,45,67,89,22,11, 9, 10, 11};
        int[] arr1 = {1,4,2,45,67,89,22,11, 9,10, 11};
        tester.populateBinaryTree(arr);
        System.out.println(tester.isPresent(tester.node,90));
        System.out.println("in order");
        tester.visitInOrder(tester.node);

        System.out.println("pre order");
        tester.visitPreOrder(tester.node);

        System.out.println("post order");
        tester.visitPostOrder(tester.node);


        System.out.println("height of the tree is "+tester.height(tester.node));

        System.out.println("min value in the tree "+tester.min(tester.node,true));
        System.out.println("min value in the tree non binary "+tester.min(tester.node,false));

        tester. populateBinaryTree2(arr1);
        System.out.println("tree equality value is "+ tester.isTreeEqual(tester.node, tester.node2));

        System.out.println("is this a binary tree"+tester.isBST(tester.node));

        tester.printValuesAtDistance(4, tester.node);

        System.out.println("The size is "+tester.size(tester.node));

        System.out.println("The leaf node count is "+tester.countLeaves(tester.node));

        System.out.println("Are they siblings"+tester.areSiblings(tester.node, 11, 89));
    }

    private TreeNodeV2 populateBinaryTree(int[] arr) {
        if(arr == null || arr.length == 0)
            return null;

        //TreeNode node = null;
        for(int n:arr){
            insertNode(node, n);
        }
        System.out.println("Hello There");
        return node;
    }


    //      1
    //          4
    //       2    45
    //         22     67
    //       11         89
    //  9        11
  //      10
    private void insertNode(TreeNodeV2 node, int n) {
        if(node == null){ // set root
            node = new TreeNodeV2();
            node.setVal(n);
            this.node = node; //set root
        }else{
            if(n <= node.getVal()){
                if(node.getLeft()!=null)
                    insertNode(node.getLeft(), n);
                else{
                    TreeNodeV2 leftNode = new TreeNodeV2(n);
                    node.setLeft(leftNode);
                    //insertNode(leftNode, n);
                }
            }else {
                if(node.getRight()!=null)
                    insertNode(node.getRight(), n);
                else{
                    TreeNodeV2 rightNode = new TreeNodeV2(n);
                    node.setRight(rightNode);
                }
            }
        }
    }


    //bad code start
    private TreeNodeV2 populateBinaryTree2(int[] arr) {
        if(arr == null || arr.length == 0)
            return null;

        //TreeNode node = null;
        for(int n:arr){
            insertNode2(node2, n);
        }
        System.out.println("Hello There, constructing node 2");
        return node2;
    }

    private void insertNode2(TreeNodeV2 node, int n) {
        if(node == null){ // set root
            node = new TreeNodeV2();
            node.setVal(n);
            this.node2 = node; //set root
        }else{
            if(n <= node.getVal()){
                if(node.getLeft()!=null)
                    insertNode2(node.getLeft(), n);
                else{
                    TreeNodeV2 leftNode = new TreeNodeV2(n);
                    node.setLeft(leftNode);
                    //insertNode(leftNode, n);
                }
            }else {
                if(node.getRight()!=null)
                    insertNode2(node.getRight(), n);
                else{
                    TreeNodeV2 rightNode = new TreeNodeV2(n);
                    node.setRight(rightNode);
                }
            }
        }
    }
//bad code end

    //      1
    //          4
    //       2    45
    //         22     67
    //       11         89

    private boolean isPresent(TreeNodeV2 node, int tF){

        if(node.getVal() == tF) {
            return true;
        }else {

            if (tF <= node.getVal() && node.getLeft()!=null) {
                return isPresent(node.getLeft(), tF);
            } else if(tF > node.getVal() && node.getRight()!=null){
                return isPresent(node.getRight(), tF);
            }
        }
       return false;

    }

    private void visitInOrder(TreeNodeV2 node){
        if(node == null){
            return;
        }

        System.out.println(node.getVal());

        visitInOrder(node.getLeft());

        visitInOrder(node.getRight());

    }


    private void visitPreOrder(TreeNodeV2 node){
        if(node == null){
            return;
        }

        visitPreOrder(node.getLeft());
        System.out.println(node.getVal());
        visitPreOrder(node.getRight());

    }

    private void visitPostOrder(TreeNodeV2 node){
        if(node == null){
            return;
        }
        visitPostOrder(node.getRight());
        visitPostOrder(node.getLeft());
        System.out.println(node.getVal());

    }

    public int height(TreeNodeV2 node){
        if(node == null || (node.getRight()==null && node.getLeft() == null)){
            return 0;
        }

        return 1+(height(node.getLeft())+height(node.getRight()));
    }

    public int min(TreeNodeV2 node, boolean isBinarySearchTree){

        if(node == null)
            throw new IllegalStateException();

        if(isBinarySearchTree) {
            return minBST(node);
        }else{
            return min(node);
        }
    }

    private int minBST(TreeNodeV2 node){
        if(node !=null && node.getLeft()!=null)
            minBST(node.getLeft());
        return node.getVal();
    }

    private int min(TreeNodeV2 node){

        if(node == null){
            return Integer.MAX_VALUE;
        }
        else if(node.getRight()==null && node.getLeft() == null){
            return node.getVal();
        }

        return Math.min(Math.min(min(node.getLeft()), min(node.getRight())), node.getVal());
    }


    public boolean isTreeEqual(TreeNodeV2 tree1, TreeNodeV2 tree2){

        return isNodeEqual(tree1, tree2);

    }

    public boolean isNodeEqual(TreeNodeV2 tree1, TreeNodeV2 tree2){

                if(tree1 == null && tree2 == null){
                    return true; //need to make sure if this is the right behavior
                }
                else if(tree1 == null || tree2 == null){
                    return false;
                }else if(tree1.getVal().equals(tree2.getVal())){
                    //code traversal is in the left to right order, you forgot about this
                    return isNodeEqual(tree1.getLeft(), tree2.getLeft()) && isNodeEqual(tree1.getRight(), tree2.getRight());
                }else{
                    return false;
                }
    }


    public boolean isBST(TreeNodeV2 treeNode){
        if(treeNode == null){
            return false;
        }
        if(treeNode.getLeft() != null && treeNode.getRight() != null &&
                treeNode.getVal()> treeNode.getLeft().getVal() && treeNode.getVal() <= treeNode.getRight().getVal()){
            return isBST(treeNode.getLeft()) && isBST(treeNode.getRight());
        }else if(treeNode.getLeft() == null && treeNode.getRight() == null){ //leaf node
            return true;
        }else if(treeNode.getLeft() != null && treeNode.getVal()> treeNode.getLeft().getVal()){
            return true;
        }else if(treeNode.getRight()!= null && treeNode.getVal() <= treeNode.getRight().getVal()){
            return true;
        }else{ // treeNode.getVal() <= treeNode.getRight().getVal()
            return false;
        }
    }

    public void printValuesAtDistance(int distance, TreeNodeV2 node){
        if(distance<0 || node == null){
            throw new IllegalStateException();
        }

        if(distance == 0 && node!=null){
            System.out.println(node.getVal());
        }else{
            if(node.getLeft()!=null) {
                printValuesAtDistance(distance - 1, node.getLeft());
            }
            if(node.getRight()!=null) {
                printValuesAtDistance(distance - 1, node.getRight());
            }
        }

    }

    public int size(TreeNodeV2 node){
        if(node == null){
            return 0;
        }
        return 1+size(node.getLeft())+size(node.getRight());
    }


    public int countLeaves(TreeNodeV2 node){
        if(node == null){
            return 0;
        }
        if(node.getRight() == null && node.getLeft() == null){
            return 1; // leaf node
        }

        return countLeaves(node.getLeft())+countLeaves(node.getRight());

    }


    //      1
    //          4
    //       2    45
    //         22     67
    //       11         89
    //  9        11
    //      10
    
    public boolean areSiblings(TreeNodeV2 node, int val1, int val2){
        if(node == null){
            return false; // throw e
        }

        
        if((node.getLeft()!= null && node.getRight()!= null)
                    &&
                    isaBoolean(node, val1, val2)){
                return true;
            }else
                return areSiblings(node.getLeft(), val1, val2) || areSiblings(node.getRight(), val1, val2);
        

    }

    private boolean isaBoolean(TreeNodeV2 node, int val1, int val2) {
        return (node.getLeft().getVal() == val1 && node.getRight().getVal() == val2)
                || (node.getLeft().getVal() == val2 || node.getRight().getVal() == val1);
    }
}
