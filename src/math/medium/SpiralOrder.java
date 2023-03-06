package math.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {


        List<Integer> result = new ArrayList<Integer>();
        // //special case
        // if(matrix.length == 1 || matrix[0].length == 1){
        //     for(int r = 0; r<matrix.length; r++){
        //         for(int c = 0; c<matrix[0].length; c++){
        //             result.add(matrix[r][c]);
        //         }
        //     }
        //     return result;
        // }

        int left = 0;
        int right = matrix[0].length-1;
        int top = 0;
        int bottom = matrix.length-1;
        int rows = matrix.length;
        int cols = matrix[0].length;
        //use the result size as a way to break the loop
        while(result.size() < rows*cols){
            //left to right
            for(int i = left; i<=right; i++){
                result.add(matrix[left][i]);
            }
            //top to bottom
            for(int i = top+1; i<=bottom; i++){
                result.add(matrix[i][right]);
            }
            //bottomright to bottomleft
            if(top != bottom){
                for(int i = right-1; i>=left; i--){
                    result.add(matrix[bottom][i]);
                }
            }
            //bottom to top
            if(left!= right){
                for(int i = bottom-1; i>top; i--){
                    result.add(matrix[i][top]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }



        return result;




        // List<Integer> result = new ArrayList<>();
        // int rows = matrix.length;
        // int columns = matrix[0].length;
        // int up = 0;
        // int left = 0;
        // int right = columns - 1;
        // int down = rows - 1;

        // while (result.size() < rows * columns) {
        //     // Traverse from left to right.
        //     for (int col = left; col <= right; col++) {
        //         result.add(matrix[up][col]);
        //     }
        //     // Traverse downwards.
        //     for (int row = up + 1; row <= down; row++) {
        //         result.add(matrix[row][right]);
        //     }
        //     // Make sure we are now on a different row.
        //     if (up != down) {
        //         // Traverse from right to left.
        //         for (int col = right - 1; col >= left; col--) {
        //             result.add(matrix[down][col]);
        //         }
        //     }
        //     // Make sure we are now on a different column.
        //     if (left != right) {
        //         // Traverse upwards.
        //         for (int row = down - 1; row > up; row--) {
        //             result.add(matrix[row][left]);
        //         }
        //     }
        //     left++;
        //     right--;
        //     up++;
        //     down--;
        // }

        // return result;
    }
}
