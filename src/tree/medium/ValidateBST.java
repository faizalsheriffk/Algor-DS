package tree.medium;

import tree.commonmodels.TreeNode;

public class ValidateBST {

    public boolean validate(TreeNode root, Integer low, Integer high) {

        //Tree traversal has reached till end with no hiccups(false cases) so it is true
        if(root == null){
            return true;
        }

        //negating a expected case to retrun false;
        if((low!=null && low >= root.val) || (high!=null && high <= root.val)){
            return false;
        }

        //low we don't care but right cannot exceed root's value for left Subtree
        //Theory of transitivity is also applicable here. You can ask - how can we maintain
        //BST constraint (entire subtree node's value is less than current node.value)? by just passing current node value as high at each level. Well, the answer is Theory of Relativity. Current node value is already less than it's parent node so making sure current node's subtree less than current node value will ensure we are good on BST Constraint
        //
        boolean isLeftValidBST = validate(root.left, low, root.val);

        //All the rules explained above applies here but, only difference is high - we don't care.
        // all the values has to be higher than root.value
        boolean isRightValidBST = validate(root.right, root.val, high);

        return isLeftValidBST&&isRightValidBST;
    }


//   public boolean validate(TreeNode root, Integer low, Integer high) {
//         // Empty trees are valid BSTs.
//         if (root == null) {
//             return true;
//         }
//         // The current node's value must be between low and high.
//         if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
//             return false;
//         }

//         boolean isR = validate(root.right, root.val, high);
//         boolean isL = validate(root.left, low, root.val);

//         // The left and right subtree must also be valid.
//         return  isR && isL;
//     }


    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }
}
