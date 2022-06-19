package tree.medium;

import tree.commonmodels.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {

        if(root == null){
            return new ArrayList();
        }

        Queue<TreeNode> pQueue = new LinkedList<TreeNode>();
        //Queue<TreeNode> cQueue = null;
        List<Integer> res = new ArrayList<Integer>();
        pQueue.add(root);
        int len = 0;

        while (!pQueue.isEmpty()){

            len = pQueue.size();
            TreeNode temp = null;
            while(len>0){
                temp = pQueue.remove();


                if(temp.left!=null){
                    pQueue.add(temp.left);
                }

                if(temp.right!=null){
                    pQueue.add(temp.right);
                }
                len--;
            }
            res.add(temp.val);

        }

        return res;
    }
}
