package binarySearch.medium;

public class SearchMatrix {
    /**
     * Search Matrix T O(logmn)
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        int r = matrix.length -1;
        boolean isFound = false;

        var top = 0;
        var bottom = matrix.length-1;


        while(top<=bottom){
            var pivotR = (top+bottom)/2;
            var len = matrix[pivotR].length-1;
            if(target >= matrix[pivotR][0] && target <=matrix[pivotR][len]){
                /**
                 * You return here as you found which row to explore
                 */
                return binarySearch(matrix, pivotR, 0, len, target);

            }else if(target > matrix[pivotR][len]){

                top = pivotR+1;
            }else{
                bottom = pivotR-1;
            }

        }
        return isFound;
    }

    /**
     * This ia a cool technique where the row and column is dedudeced
     * from the pivot = left+right/2
     * the row is pivot/n and the column is pivot%n this formula can be
     * handy
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrixCool(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0)
            return false;
        int n = matrix[0].length;

        // binary search
        int left = 0, right = m * n - 1;
        int pivotIdx, pivotElement;
        while (left <= right) {
            pivotIdx = (left + right) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement)
                return true;
            else {
                if (target < pivotElement)
                    right = pivotIdx - 1;
                else
                    left = pivotIdx + 1;
            }
        }
        return false;
    }

    /**
     * There are lot of interesting ways to solve binary search.
     * This is a recurssion technique
     * @param nums
     * @param r
     * @param start
     * @param end
     * @param target
     * @return
     */


    private boolean binarySearch(int[][] nums, int r, int start, int end, int target){

        if(end<=start){

            if(nums[r][end] == target)
                return true;
            else
                return false;
        }

        int middle = start+ ((end -start)/2);

        if(nums[r][middle] == target){
            return true;
        }

        if(target < nums[r][middle]){
            return binarySearch(nums, r, start, middle, target);
        }else{
            return binarySearch(nums, r, middle+1, end, target);
        }


    }
}
