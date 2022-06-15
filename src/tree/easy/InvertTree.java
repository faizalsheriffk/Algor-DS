package tree.easy;






class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }
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
