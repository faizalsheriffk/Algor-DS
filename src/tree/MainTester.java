package tree;

import java.util.ArrayList;
import java.util.List;

public class MainTester {

    public static void main(String[] args){
        BinaryTree binaryTree = new BinaryTree();
        int[] a = {1,4,5,2,33,11,45,67};
        for(int i:a){
            binaryTree.addNode(i);
        }

        System.out.println("______ Vising In Order _____");
        binaryTree.visitInOrder();

        System.out.println("____ Visiting Pre Order -----");
        binaryTree.visitPreOrder();

        System.out.println("______ Visiting Post Order ____");
        binaryTree.visitPostOrder();

        System.out.println("______ Visiting Breadth First ____");
        binaryTree.visitBreadthFirst();


    }
}
