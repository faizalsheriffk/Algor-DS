package tree.medium;

import tree.commonmodels.TreeNode;

/**
 * Tricky solution where diameter and height of the tree is calculated at each step
 * Unique patter the recursive path progression is based off of one parameter i.e height
 * We calculate another parameter i.e. diameter at each step
 */
public class DiameterOfTree {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        if(root == null){
            return 0;
        }

        calcDia(root);
        return this.diameter  ;
    }

    private int calcDia(TreeNode root){
        if(root == null){
            return 0;
        }
        int left =  calcDia(root.left);
        int right = calcDia(root.right);

        this.diameter = Math.max(diameter, left+right);

        return Math.max(left, right)+1;
    }
}
