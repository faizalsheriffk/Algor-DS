package tree;

public class AVLTreeTester {

    public static void main(String[] args){

        //int[] arr = {10, 5, 16, 34, 6};
        //10, 5, 16, 34, 6
        //      10
        //    5         16
        // ()     6   ()     36

        int[] arr = {4, 3, 2, 5,1,7,6};
        //        4
        //     3        5
        //  2               7
        //1             6



        //
        //     3
        //  2      5
        //1      4     7
        //          6

        AVLTree tree = new AVLTree();
        for(int i : arr)
        tree.insert(i);





        System.out.println("done inserting");
    }
}
