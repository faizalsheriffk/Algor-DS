package tree.easy;

import tree.commonmodels.TreeNode;

public class LCABsT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //constraints are very important
        //BST
        //You will find the answer in the tree

        //BST features simplify this problem
        TreeNode cur = root;

        while (cur != null) {
            if (p.val > cur.val && q.val > cur.val) {
                cur = cur.right;
            } else if (p.val < cur.val && q.val < cur.val) {
                cur = cur.left;
            } else {
                return cur;
            }
        }
        return cur;
    }
}

