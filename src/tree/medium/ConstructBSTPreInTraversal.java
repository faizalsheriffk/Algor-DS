package tree.medium;

import tree.commonmodels.TreeNode;

import java.util.HashMap;

public class ConstructBSTPreInTraversal {

    private int preorderIndex = 0;
    private HashMap<Integer, Integer> inOrderMap = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }

        for(int i = 0; i<inorder.length; i++){
            inOrderMap.put(inorder[i], i);

        }
        return buildTreeNode(preorder, 0, preorder.length-1);
    }


    private TreeNode buildTreeNode(int[] preOrder, int left, int right) {

        if (left > right) {
            return null;
        }

        //running
        int rV = preOrder[preorderIndex++];
        TreeNode root = new TreeNode(rV);
        int mid = inOrderMap.get(rV);

        //key is you are using inorder indexes on preorder to construct tree
        //A running preOrder index on the top ensures the index that we are in
        //after left and right traversal we are in root.

        root.left = buildTreeNode(preOrder, left, mid - 1);
        root.right = buildTreeNode(preOrder, mid + 1, right);

        return root;
    }

}
