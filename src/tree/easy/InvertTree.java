package tree.easy;


import tree.commonmodels.TreeNode;

public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }

        return invertTreeNodes(root);

    }

    private TreeNode invertTreeNodes(TreeNode root){

        if(root == null){
            return root;
        }

        invertTreeNodes(root.left);
        invertTreeNodes(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;

    }
}
