package tree.medium;

import tree.commonmodels.TreeNode;

public class CountGoodNodes {

    private int gN = 0;

    public int goodNodes(TreeNode root) {

        dFS(root, root.val);
        return gN;

    }

    private void dFS(TreeNode node, int maxV){

        if(node == null){
            return;
        }
        if(node.val>=maxV){
            maxV = node.val;
            gN++;
        }
        dFS(node.left, maxV);
        dFS(node.right,maxV);
    }
}
