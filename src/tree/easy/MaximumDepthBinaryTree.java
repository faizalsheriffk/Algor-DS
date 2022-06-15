package tree.easy;

public class MaximumDepthBinaryTree {

        public int maxDepth(TreeNode root) {

            if(root == null){
                return 0;
            }

            return calculateMaxDepth(root);


        }

        private int calculateMaxDepth(TreeNode root){

            if(root == null){
                return 0;
            }

            return Math.max(calculateMaxDepth(root.left), calculateMaxDepth(root.right))+1;
        }

}
