package tree.easy;

import tree.commonmodels.TreeNode;

public class BalancedBinaryTree {


        public boolean isBalanced(TreeNode root) {

            if(root == null){
                return true;
            }

            int leftH = calculateHeight(root.left);
            int rightH = calculateHeight(root.right);

            return (leftH-rightH)+1>1?false:true;

        }

        private int calculateHeight(TreeNode root){

            if(root == null){
                return -1;
            }

            return Math.max(calculateHeight(root.left), calculateHeight(root.right))+1;

        }


}
