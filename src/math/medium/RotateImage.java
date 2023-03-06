package math.medium;

public class RotateImage {
    public void rotate(int[][] matrix) {

        if(matrix.length!=matrix[0].length){
            throw new IllegalArgumentException("Matrix is not a perfect Square");
        }


        int left = 0, right = matrix.length -1;

        while(left < right){



            for(int i = 0; i<right-left; i++){
                var top = left;
                var bottom = right;
                //clockwise rotation using i
                //save top left
                var topLeft = matrix[top][left+i];
                //move bottom left into top left
                matrix[top][left+i] = matrix[bottom-i][left];
                // move bottom right into bottom left
                matrix[bottom-i][left] = matrix[bottom][right-i];
                // move bottom right into bottom left
                matrix[bottom][right-i] = matrix[top+i][right];
                // move top left into top right
                matrix[top+i][right ] = topLeft;
            }
            right--;
            left++;
        }


    }

    // int l = 0;
    //     int r = matrix.length - 1;

    //     while ( l < r )
    //     {
    //         for(int i = 0; i < r - l; i++)
    //         {
    //             int top = l;
    //             int bottom = r;
    //              //save the topleft.
    //             int topLeft = matrix[top][l + i];

    //             //move bottom left into top left
    //             matrix[top][l + i] = matrix[bottom - i][l];

    //             // move bottom right into bottom left
    //             matrix[bottom - i][l] = matrix[bottom][r - i];

    //             // move top right into bottom right
    //             matrix[bottom][r - i] = matrix[top + i][r];

    //             // move top left into top right
    //             matrix[top + i][r] = topLeft;

    //         }

    //         r -= 1;
    //         l += 1;
    //     }



    // Very powerful and easy solution reverse aroun the center from top to bottom and then swap the symmetry
    // public void rotate(int[][] matrix) {

    //     if(matrix.length!=matrix[0].length){
    //         throw new IllegalArgumentException("Matrix is not a perfect Square");
    //     }

    //     int rL = matrix.length;
    //     //reverse aroun center
    //     int top = 0;
    //     int bottom = rL-1;
    //     while(top < bottom){

    //         int[] temp = matrix[top];
    //         matrix[top] = matrix[bottom];
    //         matrix[bottom] = temp;
    //         top ++;
    //         bottom --;
    //     }

    //     //swap the symetry.
    //     for(int r = 0; r<rL; r++){
    //         for(int c = r+1; c<rL; c++){
    //             var temp = matrix[r][c];
    //             matrix[r][c] = matrix[c][r];
    //             matrix[c][r] = temp;
    //         }
    //     }

    //     return;
    // }
}
