package tree.medium;


import tree.commonmodels.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Algorithm used is BFS
 *
 * Please note: Natural intuition is to use two queues as explained below.
 * One queue can be avoided by using length of the Quwue
 */
public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList();
        }

        Queue<TreeNode> pQueue = new LinkedList<TreeNode>();
        //Queue<TreeNode> cQueue = null;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        pQueue.add(root);
        int len = 0;
        while (!pQueue.isEmpty()){
            List<Integer> list = new ArrayList<Integer>();
            len = pQueue.size();
            while(len>0){
                TreeNode temp = pQueue.remove();
                list.add(temp.val);

                if(temp.left!=null){
                    pQueue.add(temp.left);
                }

                if(temp.right!=null){
                    pQueue.add(temp.right);
                }
                len--;
            }
            res.add(list);

        }

        return res;
    }
}
