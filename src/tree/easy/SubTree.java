package tree.easy;

import tree.commonmodels.TreeNode;

/**
 * This is bit tricky pay attention
 */
public class SubTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null){
            return true;
        }
        if(root == null){
            return false;
        }
        return isTreeIdentical(root, subRoot) ||
                isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }


    private boolean isTreeIdentical(TreeNode root, TreeNode sub)      {
        if(root == null && sub == null){
            return true;
        }
        else if(root == null || sub == null){
            return false;
        }
        else if(root.val == sub.val){

            return isTreeIdentical(root.left, sub.left) &&
                    isTreeIdentical(root.right, sub.right);

        }else{
            return false;
        }

    }
}
