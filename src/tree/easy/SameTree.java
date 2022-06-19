package tree.easy;

import tree.commonmodels.TreeNode;

public class SameTree {

        public boolean isSameTree(TreeNode p, TreeNode q) {

            if(p == null && q == null){
                return true;
            }

            return isSameTreeNodes(p,q);
        }


        private boolean isSameTreeNodes(TreeNode p, TreeNode q) {
            if(p==null && q== null){
                return true;
            } else if(p == null || q == null ){
                return false;
            }else if (p.val == q.val){
                return isSameTreeNodes(p.left, q.left) &&
                        isSameTreeNodes(p.right, q.right);
            }else{
                return false;
            }
        }

}
