package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    private class Node{
        private int value;
        private Node left;
        private Node right;

        Node(int value){
            this.value = value;
        }
    }

    private Node root;

    public void addNode(int value){

        Node newNode = new Node(value);

        if(this.root == null){
            this.root = newNode;
            return;
        }

        this.root = insertNode(root, newNode);

    }

    public void removeNode(int value){

    }

    public void visitInOrder(){

        visitInOrder(root);

    }


    public void visitPreOrder(){
        visitPreOrder(root);
    }


    public void visitBreadthFirst(){

        List<Node> nList = new ArrayList<Node>();

//        System.out.println(root.value);
//        if(root.left!=null)
//        nList.add( root.left);
//
//        if(root.right!=null)
//        nList.add(root.right);
//
//        if(!nList.isEmpty()){
//            visitBreadthFirst(nList);
//        }
        nList.add(root);
        visitBreadthFirst(nList);
    }



    public void visitPostOrder(){
        visitPostOrder(root);
    }

    private void visitBreadthFirst(List<Node> nL){

        List<Node> nList = new ArrayList<Node>();

        System.out.println();
        for(Node n:nL){
            if(n != null)
                System.out.print(n.value+"  ");
            else
                System.out.print("Should not come here");

            if(n.left!=null){
                nList.add(n.left);
            }

            if(n.right!=null){
                nList.add(n.right);
            }

        }
        if(!nList.isEmpty()) {
            visitBreadthFirst(nList);
        }
    }
    private Node insertNode(Node pNode, Node cNode){

        if(pNode == null){
            pNode = cNode;
            return pNode;
        }
        if(cNode.value <= pNode.value){
            pNode.left = insertNode(pNode.left, cNode);
        }else{
            pNode.right = insertNode(pNode.right, cNode);
        }
        return pNode;
    }

    private void visitInOrder(Node node){

        if(node == null){
            return;
        }
        System.out.println(node.value);
        visitInOrder(node.left);
        visitInOrder(node.right);
    }

    private void visitPreOrder(Node node){

        if(node == null){
            return;
        }

        visitPreOrder(node.left);
        System.out.println(node.value);
        visitPreOrder(node.right);
    }

    private void visitPostOrder(Node node){

        if(node == null){
            return;
        }

        visitPostOrder(node.right);
        visitPostOrder(node.left);
        System.out.println(node.value);

    }



}
