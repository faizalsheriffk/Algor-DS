package tree;


/**
 * Lesson learnt
 * In recursive function the varible passed in method is local value type so remember that
 * Having the null tree height as -1 is the key
 */
public class AVLTree {


    private class AVLTreeNode {

        private int value;
        private int height;
        private AVLTreeNode left;
        private AVLTreeNode right;

        AVLTreeNode(){

        }

        AVLTreeNode(int val){
            this.value = val;
        }




    }


    private AVLTreeNode root;


    public void insert(int value){
        //AVLTreeNode node = new AVLTreeNode(value);

        this.root = insert(this.root, value);
    }

    //10, 5, 16, 34, 6
    //      10
    //    5         16
    // ()     6   ()     36



    //        4
    //     3        5
    //  2
    //1

    private AVLTreeNode insert(AVLTreeNode root, int value){
        if(root == null) {
            root = new AVLTreeNode(value);
            root.height = 0;
            return root;
        }

        if(value < root.value){
            root.left = insert(root.left,value);
        }else{
            root.right = insert(root.right, value);
        }

        root.height = maxHeight(root);

        int balanceFactor = calcBalanceFactor(root);

        if(balanceFactor > 1){
            System.out.println("left heavy");
            root = balanceLeftSubTree(root);
        }else if(balanceFactor < -1){
            System.out.println("right heavy");
            root = balanceRightSubtree(root);
        }else{
            System.out.println("no rotation is required");
        }

        return root;
    }


       //    5
    //    2
    //  1
    private AVLTreeNode balanceLeftSubTree(AVLTreeNode root){

        if(root.left.left != null){
            return rotateLL(root);
        }else if(root.left.right != null){
            return rotateLR(root);
        }
        return root;
        //adjust height
    }
    //        4
    //     3        5
    //  2
    //1

    private AVLTreeNode rotateLL(AVLTreeNode root){
        AVLTreeNode newRight = new AVLTreeNode(root.value);
        root = root.left;
        root.right = newRight;
        root.height = 1;
        root.left.height = 0;
        root.right.height = 0;
        return root;
    }

    //       5
    //    4
    // 3

    private AVLTreeNode rotateLR(AVLTreeNode root){
        AVLTreeNode newLeft = new AVLTreeNode(root.left.value);
        root.left = root.left.right;
        root.left.left = newLeft;
        return rotateLL(root);
    }



    private AVLTreeNode balanceRightSubtree(AVLTreeNode root){

        if(root.right.right!=null){
            return rotateRR(root);
        }else if(root.right.left != null){
            return rotateRL(root);
        }
        //adjust height
        return root;
    }


    private AVLTreeNode rotateRR(AVLTreeNode root){

        AVLTreeNode newLeft = new AVLTreeNode(root.value);
        root = root.right;
        root.left = newLeft;
        root.height = 1;
        root.left.height = 0;
        root.right.height = 0;
        return root;

    }

    //      5
    //           7
    //              6

    private AVLTreeNode rotateRL(AVLTreeNode root){
        AVLTreeNode newRight = new AVLTreeNode(root.right.value);
        root.right = root.right.left;
        root.right.right = newRight;
        return rotateRR(root);
    }

    private int maxHeight(AVLTreeNode root){
        if(root.left!=null && root.right!=null){
            return Math.max(root.left.height, root.right.height)+1;
        }else if(root.left == null){
            return root.right.height+1;
        }else if(root.right == null){
            return root.left.height+1;
        }else{
            //it should not come here
            return 0;
        }
    }

    private int calcBalanceFactor(AVLTreeNode root){
        if(root.left!=null && root.right!=null){
            return root.left.height - root.right.height;
        }else if(root.left == null){
            return (-1) - root.right.height;
        }else if(root.right == null){
            return root.left.height-(-1);
        }else{
            //it should not come here
            return 0;
        }

    }

    private boolean isBalanced(AVLTreeNode node){
        if(node == null)
            return true;



        if(root.left!=null && root.right!=null){
            return Math.abs(root.left.height-root.right.height) <= 1;
        }else if(root.left == null){
            return root.right.height <= 1 ;
        }else if(root.right == null){
            return root.left.height <= 1;
        }else{
            return true;
        }

    }

    private AVLTreeNode rotata(AVLTreeNode node){

    return null;
    }

}
