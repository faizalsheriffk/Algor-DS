package tree.medium;

import tree.commonmodels.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallest {

        private List<Integer> arr = new ArrayList<Integer>();

        public int kthSmallest(TreeNode root, int k) {
            arr.add(Integer.MIN_VALUE);
            inOrderTraverse(root);
            return arr.get(k);
        }

        private void inOrderTraverse(TreeNode root){
            if(root == null)
                return;

            inOrderTraverse(root.left);
            arr.add(root.val);
            inOrderTraverse(root.right);
        }

}
